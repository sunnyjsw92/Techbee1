package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BrowserSetup;
import utilities.ReadPropertiesFile;

import java.io.IOException;
import java.util.*;

public class GetMenuTest {

    static WebDriver webDriver;
    static Properties properties;

    {
        try {
            properties = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties/Browser"
                    + ".properties");
        } catch (IOException e) {
            System.out.println("properties file not found!");;
        }
    }
    String url = properties.getProperty("url");
    String browserName = properties.getProperty("browserName");
    RequestSpecification request = RestAssured.given();
    Response response=null;

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("url is - "+url);
        webDriver = BrowserSetup.startBrowser(webDriver,browserName, url);
    }

    @When("user goes to get the menu")
    public void user_goes_to_get_the_menu() {
        webDriver.navigate().to(properties.getProperty("urlMenu"));
        request.baseUri(properties.getProperty("urlMenu"));
    }

    @Then("the user can see the menu")
        public void the_user_can_see_the_menu() {
        response=request.get();
        Assert.assertEquals(response.getStatusCode(), 200);
        JsonPath menu = response.jsonPath();
        List<String> dishName = menu.getList("dishName");
        int noOfDishes = dishName.size();
        Assert.assertTrue(noOfDishes>0);
        List<Object> spiceLevel = menu.getList("spiceLevel");
        Set<String> spiceLevels = new HashSet<>();
        for(Object o: spiceLevel){
            spiceLevels.add((String) o);
        }
        int noOfSpiceLevels = spiceLevels.size();
        System.out.println(noOfDishes+ "- "+noOfSpiceLevels);
        Assert.assertTrue(noOfSpiceLevels>0);
        webDriver.close();
        webDriver.quit();

    }

}

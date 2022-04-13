package stepDefinitions.chef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BrowserSetup;
import utilities.ConvertToJson;
import utilities.MakePojoFromProperties;
import utilities.ReadPropertiesFile;
import vos.MenuItems;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ChefGetOrderTest {

    static WebDriver webDriver;
    static Properties properties;
    static Properties properties2;

    {
        try {
            properties = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties/Browser"
                    + ".properties");
            properties2 = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties/Passwords"
                    + ".properties");
        } catch (IOException e) {
            System.out.println("properties file not found!");
            ;
        }
    }

    String url = properties.getProperty("url");
    String browserName = properties.getProperty("browserName");
    RequestSpecification request = RestAssured.given();
    Response response;

    @Given("when the chef is on the website")
    public void when_the_chef_is_on_the_website() {
        webDriver = BrowserSetup.startBrowser(webDriver, browserName, url);
    }

    @When("the chef enters credentials to view order")
    public void the_chef_enters_credentials_to_view_order() {
        String username = properties2.getProperty("chefUn");
        String password = properties2.getProperty("chefPwd");
        request = request.auth().preemptive().basic(username, password);
        response = request.when().get(properties.getProperty("chefGet"));
    }

    @Then("all orders are shown to the chef")
    public void all_orders_are_shown_to_the_chef() {
//        System.out.println(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);
        JsonPath orders = response.jsonPath();
        List<String> users = orders.getList("user");
        List<String> orderStatus = orders.getList("orderStatus");
        System.out.println(users);
        System.out.println(orderStatus);
        Assert.assertEquals(users.size(),orderStatus.size());
        webDriver.close();
        webDriver.quit();
    }

}

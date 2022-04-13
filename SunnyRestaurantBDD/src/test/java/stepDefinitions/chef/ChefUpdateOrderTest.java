package stepDefinitions.chef;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BrowserSetup;
import utilities.ConvertToJson;
import utilities.ReadPropertiesFile;

import java.io.IOException;
import java.util.Properties;

public class ChefUpdateOrderTest {

    static WebDriver webDriver;
    static Properties properties;
    static Properties properties2;
    static Properties properties3;

    {
        try {
            properties = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties/Browser"
                    + ".properties");
            properties2 = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties/Passwords"
                    + ".properties");
            properties3 = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties"
                    + "/ChefOrderUpdate.properties");
        } catch (IOException e) {
            System.out.println("properties file not found!");
            ;
        }
    }

    String url = properties.getProperty("url");
    String browserName = properties.getProperty("browserName");
    RequestSpecification request = RestAssured.given();
    Response response;


    @Given("when the chef is on the order website")
    public void when_the_chef_is_on_the_order_website() {
        webDriver = BrowserSetup.startBrowser(webDriver, browserName, url);
    }

    @When("the chef enters credentials to update an order")
    public void the_chef_enters_credentials_to_update_an_order() throws JsonProcessingException {
        String username = properties2.getProperty("chefUn");
        String password = properties2.getProperty("chefPwd");
        String[] chefUpdate = new String[2];
        chefUpdate[0]=properties3.getProperty("orderNo");
        chefUpdate[1]=properties3.getProperty("status");
        ConvertToJson convertToJson = new ConvertToJson();
        String update = convertToJson.convertStringArrayJason(chefUpdate);
        request = request.auth().preemptive().basic(username, password);
        response = request.contentType("application/json\r\n").body(update).when()
                .put(properties.getProperty("chefPut"));
    }

    @Then("the order is updated")
    public void the_order_is_updated() {
        System.out.println(response.getBody().asPrettyString());
        Assert.assertTrue(response.getBody().asString().contains("order"));
        Assert.assertEquals(response.getStatusCode(), 200);
        webDriver.close();
        webDriver.quit();
    }


}

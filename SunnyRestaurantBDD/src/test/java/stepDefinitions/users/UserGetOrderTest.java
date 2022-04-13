package stepDefinitions.users;

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
import utilities.MakePojoFromProperties;
import utilities.ReadPropertiesFile;
import vos.RestaurantOrder;

import java.io.IOException;
import java.util.Properties;

public class UserGetOrderTest {

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
            properties3 = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties/UserGetOrder"
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

    @Given("when user is on the get order website")
    public void when_user_is_on_the_get_order_website() {
        webDriver = BrowserSetup.startBrowser(webDriver, browserName, url);
    }
    @When("user signs in and wants to get this order")
    public void user_signs_in_and_wants_to_get_this_order() {
        String username = properties2.getProperty("userUn");
        String password = properties2.getProperty("userPwd");
        String user = properties3.getProperty("user");
        request = request.auth().preemptive().basic(username, password);
        response = request.contentType("application/json\r\n").body(user).when()
                .get(properties.getProperty("userGetOrder"));
    }
    @Then("user is able to view his order")
    public void user_is_able_to_view_his_order() {
        System.out.println(response.getBody().asPrettyString());
        Assert.assertTrue(!response.getBody().asString().contains("error"));
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains(properties3.getProperty("user")));
        webDriver.close();
        webDriver.quit();
    }
}

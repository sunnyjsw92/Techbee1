package stepDefinitions.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BrowserSetup;
import utilities.ReadPropertiesFile;

import java.io.IOException;
import java.util.Properties;

public class UserDeleteOrderTest {
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
                    + "/UserDeleteOrder"
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

    @Given("when user is on the delete order website")
    public void when_user_is_on_the_delete_order_website() {
        webDriver = BrowserSetup.startBrowser(webDriver, browserName, url);
    }

    @When("user signs in and wants to delete this order")
    public void user_signs_in_and_wants_to_delete_this_order() {
        String username = properties2.getProperty("userUn");
        String password = properties2.getProperty("userPwd");
        String user = properties3.getProperty("user");
        request = request.auth().preemptive().basic(username, password);
        response = request.contentType("application/json\r\n").body(user).when()
                .delete(properties.getProperty("userDeleteOrder"));
    }
    @Then("user is able to delete his order")
    public void user_is_able_to_delete_his_order() {
        System.out.println(response.getBody().asPrettyString());
        Assert.assertTrue(!response.getBody().asString().contains("error"));
        Assert.assertEquals(response.getStatusCode(), 200);
        boolean b1 = response.getBody().asString().contains("deleted");
        boolean b2 = response.getBody().asString().contains("manager");
        boolean b3 = b1 || b2;
        Assert.assertTrue(b3);
        webDriver.close();
        webDriver.quit();
    }

}

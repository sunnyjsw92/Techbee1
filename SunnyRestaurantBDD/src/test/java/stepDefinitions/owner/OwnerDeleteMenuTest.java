package stepDefinitions.owner;

import com.fasterxml.jackson.core.JsonProcessingException;
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

public class OwnerDeleteMenuTest {

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
            properties3 = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties/DeleteMenu"
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

    @Given("owner is on the delete menu website")
    public void owner_is_on_the_deeletemenu_website() {
        webDriver = BrowserSetup.startBrowser(webDriver, browserName, url);
    }

    @When("owner logs in and deleted item")
    public void owner_logs_in_and_deleted_item() throws JsonProcessingException {
        String username = properties2.getProperty("ownerUn");
        String password = properties2.getProperty("ownerPwd");
        String dishName = properties3.getProperty("dishName");
        request = request.auth().preemptive().basic(username, password);
        response = request.contentType("application/json\r\n").body(dishName).when()
                .delete(properties.getProperty("ownerDelete"));
    }

    @Then("the menu does not show the deleted item")
    public void the_menu_does_not_show_the_deleted_item() {
        System.out.println(response.getBody().asPrettyString());
        Assert.assertTrue(response.getBody().asString().contains("successfully"));
        Assert.assertEquals(response.getStatusCode(), 200);
        webDriver.close();
        webDriver.quit();
    }

}

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

public class UserUpdateOrderTest {

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
                    + "/UserUpdateOrder"
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

    @Given("when user is on the update order website")
    public void when_user_is_on_the_website() {
        webDriver = BrowserSetup.startBrowser(webDriver, browserName, url);
    }

    @When("user signs in and updates an order")
    public void user_signs_in_and_updates_an_order() throws IOException {
        String username = properties2.getProperty("userUn");
        String password = properties2.getProperty("userPwd");
        MakePojoFromProperties makePojoFromProperties = new MakePojoFromProperties();
        RestaurantOrder order = makePojoFromProperties.updateOrderItem();
        ConvertToJson convertToJson = new ConvertToJson();
        JSONObject jsonObject = convertToJson.convertOrderJason(order);
        System.out.println(jsonObject.toString());
        request = request.auth().preemptive().basic(username, password);
        response = request.contentType("application/json\r\n").body(jsonObject.toString()).when()
                .put(properties.getProperty("userUpdateOrder"));
    }

    @Then("order is updated")
    public void order_is_updated() {
        System.out.println(response.getBody().asPrettyString());
        Assert.assertTrue(!response.getBody().asString().contains("error"));
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains(properties3.getProperty("user")));
        webDriver.close();
        webDriver.quit();
    }

}

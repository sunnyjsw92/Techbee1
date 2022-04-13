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
import vos.MenuItems;
import vos.RestaurantOrder;

import java.io.IOException;
import java.util.Properties;

public class UserPlaceOrderTest {

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
            properties3 = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties/UserPlaceOrder"
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

    @Given("when user is on the website")
    public void when_user_is_on_the_website() {
        webDriver = BrowserSetup.startBrowser(webDriver, browserName, url);
    }

    @When("user signs in and places an order")
    public void user_signs_in_and_places_an_order() throws IOException {
        String username = properties2.getProperty("userUn");
        String password = properties2.getProperty("userPwd");
        MakePojoFromProperties makePojoFromProperties = new MakePojoFromProperties();
        RestaurantOrder order = makePojoFromProperties.updateOrderItem();
        ConvertToJson convertToJson = new ConvertToJson();
        JSONObject jsonObject = convertToJson.convertOrderJason(order);
        System.out.println(jsonObject.toString());
        request = request.auth().preemptive().basic(username, password);
        response = request.contentType("application/json\r\n").body(jsonObject.toString()).when()
                .post(properties.getProperty("userPlaceOrder"));
    }

    @Then("order is generated")
    public void order_is_generated() {
        System.out.println(response.getBody().asPrettyString());
        Assert.assertTrue(!response.getBody().asString().contains("error"));
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains(properties3.getProperty("user")));
        webDriver.close();
        webDriver.quit();
    }

}

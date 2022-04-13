package stepDefinitions.owner;

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

import java.io.IOException;
import java.util.Properties;

public class OwnerUpdateMenuTest {

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
            properties3 = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties/UpdateMenu"
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

    @Given("owner is on the getmenu website")
    public void owner_is_on_the_getmenu_website() {
        webDriver = BrowserSetup.startBrowser(webDriver, browserName, url);
    }

    @When("owner logs in and updates an item")
    public void owner_logs_in_and_updates_an_item() throws IOException {
        String username = properties2.getProperty("ownerUn");
        String password = properties2.getProperty("ownerPwd");
        MakePojoFromProperties makePojoFromProperties = new MakePojoFromProperties();
        MenuItems menuItems = makePojoFromProperties.updateMenuItems();
        ConvertToJson convertToJson = new ConvertToJson();
        JSONObject jsonObject = convertToJson.convertMenuItemsJason(menuItems);
        request = request.auth().preemptive().basic(username, password);
        response = request.contentType("application/json\r\n").body(jsonObject.toString()).when()
                .put(properties.getProperty("ownerUpdate"));
    }

    @Then("the menu shows the updated item")
    public void the_menu_shows_the_updated_item() {
        System.out.println(response.getBody().asPrettyString());
        Assert.assertTrue(response.getBody().asString().contains("successfully"));
        Assert.assertEquals(response.getStatusCode(), 200);
        webDriver.close();
        webDriver.quit();
    }

}

package runners.users;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//user update order runner class

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/User/UserUpdateOrder.feature", glue = {
        "stepDefinitions"}, monochrome =
        true, plugin = {"pretty", "junit:target/JunitReports/Report.xml", "json:target/JSONReports/report"
        + ".json", "html:target/HtmlReports/report.html"}, tags = "@UserUpdateOrder and @UserUpdateOrderTest")
public class USerUpdateOrderRunner {

}

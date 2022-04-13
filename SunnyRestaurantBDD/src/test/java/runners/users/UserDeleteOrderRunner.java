package runners.users;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//user delete order runner class
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/User/UserDeleteOrder.feature", glue = {
        "stepDefinitions"}, monochrome =
        true, plugin = {"pretty", "junit:target/JunitReports/Report.xml", "json:target/JSONReports/report"
        + ".json", "html:target/HtmlReports/report.html"}, tags = "@UserDeleteOrder and @UserDeleteOrderTest")
public class UserDeleteOrderRunner {

}

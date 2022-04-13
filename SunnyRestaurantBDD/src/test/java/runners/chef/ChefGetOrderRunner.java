package runners.chef;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//chef order runner class
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/Chef/ChefGetOrder.feature", glue = {
        "stepDefinitions"}, monochrome =
        true, plugin = {"pretty", "junit:target/JunitReports/Report.xml", "json:target/JSONReports/report"
        + ".json", "html:target/HtmlReports/report.html"}, tags = "@ChefGetOrder and @ChefGetOrderTest")
public class ChefGetOrderRunner {

}

package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//get menu runner class - no access issue, open to all

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/GetMenu.feature", glue = {"stepDefinitions"},
        monochrome =
        true, plugin = {"pretty", "junit:target/JunitReports/Report.xml", "json:target/JSONReports/report"
        + ".json", "html:target/HtmlReports/report.html"}, tags = "@GetMenu")
public class GetMenuRunner {

}

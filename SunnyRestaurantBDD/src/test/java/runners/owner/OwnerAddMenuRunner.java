package runners.owner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//owner add menu runner class
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/Owner/OwnerAddMenu.feature", glue = {
        "stepDefinitions"}, monochrome =
        true, plugin = {"pretty", "junit:target/JunitReports/Report.xml", "json:target/JSONReports/report"
        + ".json", "html:target/HtmlReports/report.html"}, tags = "@OwnerAddMenu and @OwnerAddTest")
public class OwnerAddMenuRunner {

}

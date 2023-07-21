package runner;

import io.cucumber.testng.CucumberOptions;
import pages.TestBase;

@CucumberOptions(features = "src/test/java/features"
    ,glue = "steps",
    tags = "@subscribe"
    ,plugin = {"pretty","html:target/cucumber-html-report.html"})
public class TestRunner extends TestBase {

}

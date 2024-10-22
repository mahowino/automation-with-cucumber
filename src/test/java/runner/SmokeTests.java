package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "StepDefinitions",
  monochrome = true, plugin = {
  "pretty",
  "html:target/HtmlReports.html",
  "json:target/testReport/cucumber_smoke.json",
  "html:target/testReport/cucumber_smoke.html",
},
  tags = "@smokeTests"
)
public class SmokeTests {
}

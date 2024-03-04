package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//cucumber/bike.feature",
		glue="Stepdefinition",
		dryRun=false,
		monochrome=true,
		publish=true,
		plugin= {"html:reports/CucumberReport.html"})

public class TestRunner {


}

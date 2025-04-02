package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Feature/feature.feature", // Path to feature file
		glue = "stepDefinition", // Package containing step definitions
		plugin = { "pretty", "html:target/html-cucumber.html", "json:target/cucumber.json" }, 
		monochrome = true,
		dryRun = false
		)
		


public class TestRunner {
}

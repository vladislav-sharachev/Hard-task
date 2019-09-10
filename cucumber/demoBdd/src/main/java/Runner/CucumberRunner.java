package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty",
		features = "src/main/resources",
		glue = "StepDefs",
		tags = {"@Regression", "not @WrongLoginTest"}
)
public class CucumberRunner {

/*	@AfterClass
	public static void teardown() {
		DriverManager.getDriver().close();
	}*/
}
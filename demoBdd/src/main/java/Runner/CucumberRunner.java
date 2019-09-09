package Runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import DriverManager.DriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty",
		features = "src/main/resources",
		glue = "StepDefs",
		tags = "@TestLogin"
)
public class CucumberRunner {

/*	@AfterClass
	public static void teardown() {
		DriverManager.getDriver().close();
	}*/
}
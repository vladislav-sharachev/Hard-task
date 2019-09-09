package StepDefs;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.yecht.Data;

import DriverManager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sun.management.snmp.jvminstr.JvmOSImpl;

public class CommonStepDefs extends AbstractStepDefs {
    @Given("I open main page")
    public void i_open_main_page() {
        DriverManager.getDriver().get("https://yandex.ru");
    }


    @When("I check that message visible on main page")
    public void i_check_that_message_withible_on_main_page() {
        Assert.assertTrue("Element should be visible",
                onMainPage().isPleaseLoginMessageVisible());
    }

    @Then("I click on the login button")
    public void i_click_on_the_login_button() {
        onMainPage().clickToEnter();
    }

    @When("I fill fields with login (.*)")
    public void i_fill_fields_with_login(String username) {
        onLoginForm().typeUsername(username);
    }

    @Then("I click on the further button")
    public void i_click_on_the_further_button() {
    	onLoginForm().clickToSubmitUserName();
    }
    @When("I fill fields with password (.*)")
	public void i_fill_fields_with_password(String password) {
    	onLoginForm().typePassword(password);
	}
	@Then("I click on the enter button")
	public void i_click_on_the_enter_button() {
    	onLoginForm().clickToSubmitPassword();
	}
	@And("I check input")
	public void i_check_input() {}

    @Given("I clear cache")
    public void I_clear_cache() {
        //todo implement me
    }

}
package StepDefs;

import DriverManager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MainPageStepDefs extends AbstractStepDefs {
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
}
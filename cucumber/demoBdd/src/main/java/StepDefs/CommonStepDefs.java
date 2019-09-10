package StepDefs;

import io.cucumber.java.en.And;
import org.junit.Assert;
import DriverManager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    @Given("I fill fields with login (.*)")
    public void i_fill_fields_with_login(String username) {
        onLoginForm().typeUsername(username);
    }

    @When("I click on the further button")
    public void i_click_on_the_further_button() {
        onLoginForm().clickToSubmitUserName();
    }

    @And("I fill fields with password (.*)")
    public void i_fill_fields_with_password(String password) {
        onLoginForm().typePassword(password);
    }

    @And("I click on the enter button")
    public void i_click_on_the_enter_button() {
        onLoginForm().clickToSubmitPassword();
    }

    @Then("I check input")
    public void i_check_input() {
        Assert.assertTrue("Element should be visiale",
                onLoginForm().inputIsSuccessful());
    }

    @Then("I check an exception")
    public void i_check_an_exception() {
        Assert.assertTrue("Element should be visiale", onLoginForm().anExceptionShowed());
    }

    @Given("I write first letter")
    public void i_write_first_letter() {
        onNewMailPage().clickToWriteLetter();
        onNewMailPage().firstAdress();
        onNewMailPage().letterWriteAndSave();
    }

    @And("I write second letter")
    public void i_write_second_letter() {
        onNewMailPage().clickToWriteLetter();
        onNewMailPage().secondAdress();
        onNewMailPage().letterWriteAndSave();
    }

    @And("I write third letter")
    public void i_write_third_letter() {
        onNewMailPage().clickToWriteLetter();
        onNewMailPage().thirdAdress();
        onNewMailPage().letterWriteAndSave();
    }

    @When("I go to drafts")
    public void i_go_to_drafts() {
        onDraftPage().goToDrafts();
    }

    @Then("I verify drafts")
    public void i_verify_drafts() {
        Assert.assertTrue("Element should be visible", onDraftPage().verifyFirstDraft());
        Assert.assertTrue("Element should be visible", onDraftPage().verifySecondDraft());
        Assert.assertTrue("Element should be visible", onDraftPage().verifyThirdDraft());
    }

    @Given("I select all drafts")
    public void io_select_all_drafts() {
        onDraftPage().selectAllDrafts();
    }

    @When("I click to delete the drafts")
    public void i_click_to_delete_the_drafts() {
        onDraftPage().deleteAllDrafts();
    }

    @Then("I check that the drafts were deleted")
    public void i_check_that_the_drafts_were_deleted() {
        onDraftPage().verifyTheDraftsWereDeleted();
    }

    @Given("I clear cache")
    public void I_clear_cache() {
        //todo implement me
    }

}
package StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NewLetterlStepDefs extends AbstractStepDefs {
    @Given("I write a first letter")
    public void i_write_a_first_letter() {
        onNewMailPage().writeFirstLetter();
    }

    @And("I write a second letter")
    public void i_write_a_second_letter() {
        onNewMailPage().writeSecondLetter();
    }

    @And("I write a third letter")
    public void i_write_a_third_letter() {
        onNewMailPage().writeThirdLetter();
    }

    @When("I go to drafts")
    public void i_go_to_drafts() {
        onDraftPage().goToDrafts();
    }

    @Then("I verify the drafts")
    public void i_verify_the_drafts() {
        onDraftPage().verifyAllDrafts();
    }
}
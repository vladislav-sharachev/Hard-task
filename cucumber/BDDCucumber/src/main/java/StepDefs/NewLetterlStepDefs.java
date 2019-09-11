package StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NewLetterlStepDefs extends AbstractStepDefs {
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
}
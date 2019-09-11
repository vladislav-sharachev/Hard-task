package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DraftsStepDefs extends AbstractStepDefs {
    @Given("I select all the drafts")
    public void io_select_all_the_drafts() {
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
}
@Regression @TestDraft
Feature: Drafts test

  @DraftsTests
  Scenario Outline: Create 3 drafts
    Given I open main page
    And I check that message visible on main page
    And I click on the login button
    And I fill fields with login <login>
    And I click on the further button
    And I fill fields with password <password>
    And I click on the enter button
    And I check successful log in
    When I write a first letter
    And I write a second letter
    And I write a third letter
    And I go to drafts
    Then I verify the drafts

    Examples:
      | login        | password      |
      | mail-for-bdd | mail-for-bdd1 |


  @DeleteDraftsTests
  Scenario: Delete all the drafts
    Given I select all the drafts
    When I click to delete the drafts
    Then I check that the drafts were deleted
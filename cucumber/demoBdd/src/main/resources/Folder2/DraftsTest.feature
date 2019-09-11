@Regression @TestDraft
Feature: Drafts test

  @OpenApplicationTwo
  Scenario: Check that main page opened
    Given I open main page
    When I check that message visible on main page

  @Login
  Scenario Outline: Check of working login and logout
    Given I click on the login button
    And I fill fields with login <login>
    When I click on the further button
    And I fill fields with password <password>
    And I click on the enter button
    Then I check input

    Examples:
      | login        | password      |
      | mail-for-bdd | mail-for-bdd1 |

  @DraftsTests
  Scenario: Create 3 drafts
    Given I write first letter
    And I write second letter
    And I write third letter
    When I go to drafts
    Then I verify drafts


  @DeleteDraftsTests
  Scenario: Delete all drafts
    Given I select all drafts
    When I click to delete the drafts
    Then I check that the drafts were deleted
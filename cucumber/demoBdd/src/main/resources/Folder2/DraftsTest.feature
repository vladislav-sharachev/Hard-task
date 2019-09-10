@Regression @TestDraft (order = 20)
Feature: Drafts test

  Background: cleaning up
    Given I clear cache

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
@Regression @TestLogin
Feature: Sample test

  Background: cleaning up
    Given I clear cache

  @TestOpenApplication
  Scenario: Check that main page opened
    Given I open main page
    When I check that message visible on main page
    Then I click on the login button

  @LoginTest
  Scenario Outline: Check that login page opened
    When I fill fields with login <login>
    Then I click on the further button
    When I fill fields with password <password>
    Then I click on the enter button
    And I check input

    Examples:
      | login        | password      |
      | mail-for-bdd | mail-for-bdd1 |
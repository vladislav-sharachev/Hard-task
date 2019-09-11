@Regression @TestLogin
Feature: Login test

  @OpenApplication
  Scenario: Check that main page opened
    Given I open main page
    When I check that message visible on main page

  @LoginTest
  Scenario Outline: Check of working login and logout
    Given I click on the login button
    And I fill fields with login <login>
    When I click on the further button
    And I fill fields with password <password>
    And I click on the enter button
    Then I check input
    And I am logging out
    And I check logout

    Examples:
      | login        | password      |
      | mail-for-bdd | mail-for-bdd1 |


  @DeleteUser
  Scenario: Deleting old user
    Given I open main page
    When I check that message visible on main page
    Given I click on the login button
    Given I log out of the previous account


  @WrongLoginTest
  Scenario Outline: Check for invalid password
    Given I open main page
    When I check that message visible on main page
    Given I click on the login button
    And I fill fields with login <login>
    When I click on the further button
    Then I check an exception

    Examples:
      | login          |
      | hu-hu-hu-go123 |
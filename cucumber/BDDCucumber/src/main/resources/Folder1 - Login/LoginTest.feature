@Regression @TestLogin
Feature: Login test

  Background: Opening main page
    Given I open main page
    When I check that message visible on main page
    Then I click on the login button

  @LoginTest
  Scenario Outline: Check of working login and logout
    Given I fill fields with login <login>
    When I click on the further button
    And I fill fields with password <password>
    And I click on the enter button
    Then I check input
    And I am logging out
    And I check logout
    And I open main page
    And I check that message visible on main page
    And I click on the login button
    And I log out of the previous account

    Examples:
      | login        | password      |
      | mail-for-bdd | mail-for-bdd1 |

  @WrongLoginTest
  Scenario Outline: Check for invalid password
    Given I fill fields with login <login>
    When I click on the further button
    Then I check an exception

    Examples:
      | login          |
      | hu-hu-hu-go123 |
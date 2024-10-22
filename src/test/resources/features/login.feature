@smokeTests
Feature: Feature to test login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters <email> and <password>
    And clicks on login button
    Then user is navigated to homepage
    Examples:
      | email | password |
      | standard_user | secret_sauce |
      | problem_user | secret_sauce |




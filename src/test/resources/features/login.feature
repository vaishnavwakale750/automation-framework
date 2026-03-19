Feature: Login functionality


  @smoke @login
  Scenario: Verify login page
    Given user is on login page
    Then page title should contain "Swag"

  @regression @login
  Scenario: Verify invalid login
    Given user is on login page
    When user enters invalid credentials
    Then error message should be displayed
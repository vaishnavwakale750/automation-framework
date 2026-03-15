Feature: Login functionality

  Scenario: Verify login page title

    Given user is on login page
    Then page title should contain "Swag"
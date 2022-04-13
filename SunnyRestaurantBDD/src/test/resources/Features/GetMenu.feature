@GetMenu
Feature: test that menu is accessible to all without login credentials

  @MenuTest
  Scenario: validate that menu is accessible without sign-in
    Given browser is open
    When user goes to get the menu
    Then the user can see the menu

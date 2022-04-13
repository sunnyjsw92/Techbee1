@OwnerAddMenu
Feature: validate that owner can add, delete and update menu items

  @OwnerAddTest
  Scenario: owner can add menu items
    Given owner is on the website
    When owner adds an item to the menu
    Then the menu shows the update item

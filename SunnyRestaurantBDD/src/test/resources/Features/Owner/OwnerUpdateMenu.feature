@OwnerUpdateMenu
Feature: validate that owner can add, delete and update menu items

  @OwnerUpdateTest
  Scenario: owner can update menu
    Given owner is on the getmenu website
    When owner logs in and updates an item
    Then the menu shows the updated item

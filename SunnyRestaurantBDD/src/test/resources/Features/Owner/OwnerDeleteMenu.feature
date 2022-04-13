@OwnerDeleteMenu
  Feature: validate that owner can add, delete and update menu items

    @OwnerDeleteMenuTest
    Scenario: owner can delete menu
      Given owner is on the delete menu website
      When owner logs in and deleted item
      Then the menu does not show the deleted item
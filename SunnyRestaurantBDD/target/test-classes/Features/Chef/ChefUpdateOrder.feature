@ChefUpdateOrder
Feature: chef can view and modify orders

  @ChefUpdateOrderTest
  Scenario: chef can update orders
  Given when the chef is on the order website
    When the chef enters credentials to update an order
    Then the order is updated
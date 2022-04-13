@ChefGetOrder
Feature: chef can view and modify orders

  @ChefGetOrderTest
  Scenario: chef can see orders
  Given when the chef is on the website
    When the chef enters credentials to view order
    Then all orders are shown to the chef
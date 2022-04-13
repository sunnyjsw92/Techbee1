@UserUpdateOrder
Feature: user is able to place, update, delete and get orders

  @UserUpdateOrderTest
  Scenario: user is able to place an order
    Given when user is on the update order website
    When user signs in and updates an order
    Then order is updated
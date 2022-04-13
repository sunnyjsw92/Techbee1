@UserPlaceOrder
  Feature: user is able to place, update, delete and get orders

    @UserPlaceOrderTest
    Scenario: user is able to place an order
      Given when user is on the website
      When user signs in and places an order
      Then order is generated

@UserGetOrder
Feature: user is able to place, update, delete and get orders

  @UserGetOrderTest
  Scenario: user is able to get his/her order
    Given when user is on the get order website
    When user signs in and wants to get this order
    Then user is able to view his order
@UserDeleteOrder
Feature: user is able to delete his/herorders

  @UserDeleteOrderTest
  Scenario: user is able to delete order
    Given when user is on the delete order website
    When user signs in and wants to delete this order
    Then user is able to delete his order
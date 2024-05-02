@wip
Feature: shopping cart

  Background:
    Given The user is logged in

   @add-items-to-cart
  Scenario:  Shopping Cart test
    Given The user select jacket option from tops of women page and select color and price filters
    And The user adds all items into shoping card
    Then The user verifies success message is displayed
    And The user clicks shopping cart link from success message
    Then The user verify that is landed in shopping cart page
    And The sum of products amount is the same as total price

   @delete-from-cart
    Scenario:  Empty Shopping Cart Test
      Given The user adds items in shopping card
      When The user delete items from shopping cart
      Then The user verifies that item are deleted one by one
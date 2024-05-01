Feature: filters
  Background:
    Given The user is logged in

    @color-filter @wip
    Scenario: Check color Filter
      When The user clicks women dropdown
      And The user selects jacket option under tops dropdown
      And The user selects a color
      Then The user verifies that all products have selected the same color
      And The user selects a range price
      Then The user verifies that all products have the price within the selectet range
      And The user verifies that only two products are displayed



  Scenario: Wish list test
    Given The user select jacket option from tops of women page and select color and price filters
    When The user removes price filter
    Then The user verifies the number of products incresed
    And The user adds first two items in the wish list
    Then The user verifies that successful message is displayed
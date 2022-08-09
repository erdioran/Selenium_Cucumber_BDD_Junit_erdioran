Feature: Defacto Case

  Scenario Outline: Case 1
    Given user is on "<url>" page
    Then check home page load
    When hover over "<category name>" category
    And click "<sub category>"
    Then check category product count
    And choose "<size>" size in filter
    And click random product
    Then check product detail page load
    And save product name
    And save product price
    And choose random size in product detail
    Then add to basket
    And click basket summary
    And click go to basket
    Then check basket page load
    Then check product name
    Then check product price
    And delete last product in basket
    Then check basket is empty

    Examples:
      | url  | category name | sub category   | size |
      | home | kadın         | kadın pantolon | S    |




Feature: Search for flight feature

  Scenario: It should display booking price
    Given I am on search page
    And I enter start destination
    And I enter end destination
    When I search for flight
    Then list of flights is visible
    And first flight contains price in correct format
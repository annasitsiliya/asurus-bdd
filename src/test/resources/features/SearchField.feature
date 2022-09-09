Feature: Test scenarios for Amazon search field

  Scenario: User sees no results message for incorrect input

    Given User is on Amazon home page
    When User searches for "456546765876988708"
    Then User sees no results message for "456546765876988708"


  Scenario: Search term is present in search summary string

    Given User is on Amazon home page
    When User searches for "laptop"
    Then User sees result summary string with "laptop"

  Scenario: At least one found element contains search term

    Given User is on Amazon home page
    When User searches for "iphone"
    Then Search result items contain "iphone"





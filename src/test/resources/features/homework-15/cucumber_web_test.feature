Feature: Allo test

Scenario: search, fetch and save to DB 3 Iphone cards
    Given I load Allo.ua page
    Given I search "Iphone" products page
    When I get product cards, not less then 3
    When I get from product cards models and prices for 3 cards
    Then I insert models and prices into phones

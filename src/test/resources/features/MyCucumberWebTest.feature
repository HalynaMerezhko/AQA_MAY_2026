Feature: All in one test

  Scenario: retrieve and search for random people
    Given I request 3 random people from random user service as "random people"
    Given I store "random people" in DB
    When I pick one random person from DB as "random person"
    When I load google page
    When I accept cookies if present
    Then I set search input to "random person" name

  Scenario: retrieve and search for random people
    Given A person with data "custom user"
      | first  | Bill   |
      | last   | Murray |
      | title  | Mr     |
      | gender | male   |
      | nat    | US     |
    Given I store "custom user" in DB

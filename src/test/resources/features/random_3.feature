Feature: Tests that sometimes fail

  @severity=blocker
  Scenario: Fails 1 in 100
    Given Fail 1 in 100 for "page_9"

  @severity=critical
  Scenario: Fails 1 in 50
    Given Fail 1 in 50 for "page_10"

  @severity=minor
  Scenario: Fails 1 in 25
    Given Fail 1 in 25 for "page_11"

  @severity=trivial
  Scenario: Fails 1 in 5
    Given Fail 1 in 5 for "page_12"
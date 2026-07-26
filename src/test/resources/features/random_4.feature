Feature: Tests that sometimes fail

  @severity=blocker
  Scenario: Fails 1 in 100
    Given Fail 1 in 100 for "page_13"

  @severity=critical
  Scenario: Fails 1 in 50
    Given Fail 1 in 50 for "page_14"

  @severity=minor
  Scenario: Fails 1 in 25
    Given Fail 1 in 25 for "page_15"

  @severity=trivial
  Scenario: Fails 1 in 5
    Given Fail 1 in 5 for "page_16"
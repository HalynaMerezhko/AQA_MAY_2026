Feature: my first feature

  Scenario: my first scenario 1
    Given I have something "here"
    When I do something 10 times
    Then I click SEARCH_BUTTON

  Scenario: Data table demo
    Given data table stuff
      | userName  | test_name      |
      | userPwd   | test_pwd       |
      | userEmail | test@gmail.com |
      | userPhone | +123565435     |

  Scenario Outline: rerunnable
    Given I have something "<param_1>"
    When I do something <param_2> times
    Examples:
      | param_1       | param_2 |
      | here_is_one   | 1       |
      | here_is_two   | 2       |
      | here_is_three | 3       |

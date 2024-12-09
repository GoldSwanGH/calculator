Feature: Division functionality
  To ensure accurate division operations
  As a calculator user
  I want to divide two numbers and compare the results for both implementations.

  Scenario: Dividing two positive numbers
    Given I have a calculator of type "CalculationService"
    And I have another calculator of type "AlternativeCalculationService"
    When I call the divide method on the first calculator with 20 and 4
    And I call the divide method on the second calculator with 20 and 4
    Then the result of the first calculator should be 5
    And the result of the second calculator should also be 5

  Scenario: Division by zero
    Given I have a calculator of type "CalculationService"
    And I have another calculator of type "AlternativeCalculationService"
    When I call the divide method on the first calculator with 5 and 0
    And I call the divide method on the second calculator with 5 and 0
    Then both calculators should throw an ArithmeticException with the message "Division by zero is not allowed."

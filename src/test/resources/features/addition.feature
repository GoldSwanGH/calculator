Feature: Addition functionality
  To simplify basic arithmetic
  As a calculator user
  I want to add two numbers and verify the results for both implementations.

  Scenario: Adding two positive numbers
    Given both implementations of the calculator are ready
    When the numbers 5.0 and 3.0 are added
    Then the result for both implementations should be 8.0

  Scenario: Adding a positive and a negative number
    Given both implementations of the calculator are ready
    When the numbers 10.0 and -2.0 are added
    Then the result for both implementations should be 8.0

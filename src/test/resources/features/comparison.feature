Feature: Comparison of calculator implementations
  To ensure accurate results
  As a developer
  I want to compare two implementations of the calculator.

  Scenario Outline: Comparing results for arithmetic operations
    Given both implementations of the calculator are ready
    When I perform the operation "<operation>" with <number1> and <number2> using both calculators
    Then the results of both calculators should be <expectedResult>

    Examples:
      | operation  | number1 | number2 | expectedResult |
      | add        | 100     | 200     | 300            |
      | subtract   | 1000    | 500     | 500            |
      | multiply   | 45      | 2       | 90             |
      | divide     | 100     | 10      | 10             |
package goldswan.calculator;

import goldswan.calculator.service.AlternativeCalculationService;
import goldswan.calculator.service.CalculationService;
import goldswan.calculator.service.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    private Calculator standardCalculator;
    private Calculator alternativeCalculator;
    private double standardResult;
    private double alternativeResult;
    private Exception standardException;
    private Exception alternativeException;

    @Given("both implementations of the calculator are ready")
    public void both_implementations_of_the_calculator_are_ready() {
        standardCalculator = new CalculationService();
        alternativeCalculator = new AlternativeCalculationService();
    }

    @When("the numbers {double} and {double} are added")
    public void the_numbers_and_are_added(Double double1, Double double2) {
        standardResult = standardCalculator.add(double1, double2);
        alternativeResult = alternativeCalculator.add(double1, double2);
    }

    @Then("the result for both implementations should be {double}")
    public void the_result_for_both_implementations_should_be(Double double1) {
        assertEquals(double1, standardResult, "Standard calculator result is incorrect");
        assertEquals(double1, alternativeResult, "Alternative calculator result is incorrect");
    }

    @Given("I have a calculator of type {string}")
    public void i_have_a_calculator_of_type(String type) {
        if (type.equals("CalculationService")) {
            standardCalculator = new CalculationService();
        } else if (type.equals("AlternativeCalculationService")) {
            standardCalculator = new AlternativeCalculationService();
        }
    }

    @Given("I have another calculator of type {string}")
    public void i_have_another_calculator_of_type(String type) {
        if (type.equals("AlternativeCalculationService")) {
            alternativeCalculator = new AlternativeCalculationService();
        } else if (type.equals("CalculationService")) {
            alternativeCalculator = new CalculationService();
        }
    }

    @When("I call the divide method on the first calculator with {double} and {double}")
    public void i_call_divide_method_on_first_calculator(double number1, double number2) {
        try {
            standardResult = standardCalculator.divide(number1, number2);
        } catch (Exception e) {
            standardException = e;
        }
    }

    @When("I call the divide method on the second calculator with {double} and {double}")
    public void i_call_divide_method_on_second_calculator(double number1, double number2) {
        try {
            alternativeResult = alternativeCalculator.divide(number1, number2);
        } catch (Exception e) {
            alternativeException = e;
        }
    }

    @Then("the result of the first calculator should be {double}")
    public void the_result_of_first_calculator_should_be(double expected) {
        assertEquals(expected, standardResult, "Standard calculator result is incorrect");
    }

    @Then("the result of the second calculator should also be {double}")
    public void the_result_of_second_calculator_should_be(double expected) {
        assertEquals(expected, alternativeResult, "Alternative calculator result is incorrect");
    }

    @Then("both calculators should throw an ArithmeticException with the message {string}")
    public void both_calculators_should_throw_exception(String message) {
        assertNotNull(standardException, "Standard calculator did not throw an exception");
        assertNotNull(alternativeException, "Alternative calculator did not throw an exception");

        assertInstanceOf(ArithmeticException.class, standardException, "Standard exception is not ArithmeticException");
        assertInstanceOf(ArithmeticException.class, alternativeException, "Alternative exception is not ArithmeticException");

        assertEquals(message, standardException.getMessage(), "Standard exception message is incorrect");
        assertEquals(message, alternativeException.getMessage(), "Alternative exception message is incorrect");
    }

    @When("I perform the operation {string} with {double} and {double} using both calculators")
    public void i_perform_the_operation_with_using_both_calculators(String operation, double number1, double number2) {
        standardResult = performOperation(standardCalculator, operation, number1, number2);
        alternativeResult = performOperation(alternativeCalculator, operation, number1, number2);
    }

    @Then("the results of both calculators should be {double}")
    public void the_results_of_both_calculators_should_be(double expected) {
        assertEquals(expected, standardResult, "Standard calculator result is incorrect");
        assertEquals(expected, alternativeResult, "Alternative calculator result is incorrect");
    }

    private double performOperation(Calculator calculator, String operation, double number1, double number2) {
        switch (operation) {
            case "add":
                return calculator.add(number1, number2);
            case "subtract":
                return calculator.subtract(number1, number2);
            case "multiply":
                return calculator.multiply(number1, number2);
            case "divide":
                return calculator.divide(number1, number2);
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }
}


package goldswan.calculator.service;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

public class CalculationServiceFuzzTest {
    private final CalculationService calculator = new CalculationService();

    @FuzzTest(maxDuration = "10s")
    void fuzz(FuzzedDataProvider data) {
        double number1 = data.consumeDouble();
        double number2 = data.consumeDouble();

        if (number2 == 0.0) {
            throw new RuntimeException("boo!");
        }
        calculator.add(number1, number2);

        calculator.subtract(number1, number2);

        calculator.multiply(number1, number2);

        try {
            calculator.divide(number1, number2);
        } catch (Exception e) {
            if (!"Division by zero is not allowed.".equals(e.getMessage())) {
                throw new RuntimeException("Unexpected exception during division fuzzing", e);
            }
        }
    }
}
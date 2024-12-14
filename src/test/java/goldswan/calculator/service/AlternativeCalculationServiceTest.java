// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package goldswan.calculator.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlternativeCalculationServiceTest extends CalculatorTest {

    public AlternativeCalculationServiceTest() {
        super(new AlternativeCalculationService());
    }

    private final CalculationService originalCalculator = new CalculationService();

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void compareAdditionWithOriginal(double number1, double number2) {

        // Вычисляем результаты обеих реализаций
        double originalResult = originalCalculator.add(number1, number2);
        double alternativeResult = calculator.add(number1, number2);

        // Сравниваем результаты с учетом допустимой погрешности
        assertThat("Addition results should match",
                originalResult, closeTo(alternativeResult, DELTA));
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void comparetestSubtractionWithOriginal(double number1, double number2) {

        double originalResult = originalCalculator.subtract(number1, number2);
        double alternativeResult = calculator.subtract(number1, number2);

        assertThat("Subtraction results should match", originalResult, closeTo(alternativeResult, DELTA));
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void comparetestMultiplicationWithOriginal(double number1, double number2) {

        double originalResult = originalCalculator.multiply(number1, number2);
        double alternativeResult = calculator.multiply(number1, number2);

        assertThat("Multiplication results should match", originalResult, closeTo(alternativeResult, DELTA));
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void comparetestDivisionWithOriginal(double number1, double number2) {

        if (number2 == 0) {
            assertThrows(ArithmeticException.class, () -> originalCalculator.divide(number1, number2));
            assertThrows(ArithmeticException.class, () -> calculator.divide(number1, number2));
        } else {
            double originalResult = originalCalculator.divide(number1, number2);
            double alternativeResult = calculator.divide(number1, number2);

            assertThat("Division results should match", originalResult, closeTo(alternativeResult, DELTA));
        }
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(1.0, 2.0),
                Arguments.of(-0.5, 2.8),
                Arguments.of(7.2, -1.1),
                Arguments.of(-10.2, -5.1),
                Arguments.of(9.12, 0.0),
                Arguments.of(-1.75, 0.0),
                Arguments.of(0.0, 21.0),
                Arguments.of(0.0, -1.7),
                Arguments.of(0.0, 0.0),
                Arguments.of(32.125, 1.0),
                Arguments.of(194.523, 4.239)
        );
    }
}

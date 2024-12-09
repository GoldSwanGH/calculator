package goldswan.calculator.service;

import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@AllArgsConstructor
public abstract class CalculatorTest {

    protected static final double DELTA = 1e-6;
    protected final Calculator calculator;

    @ParameterizedTest
    @MethodSource("provideAdditionData")
    public void testAddition(double number1, double number2, double expected) {
        double result = calculator.add(number1, number2);
        assertThat(result, closeTo(expected, DELTA));
    }

    @ParameterizedTest
    @MethodSource("provideSubtractionData")
    public void testSubtraction(double number1, double number2, double expected) {
        double result = calculator.subtract(number1, number2);
        assertThat(result, closeTo(expected, DELTA));
    }

    @ParameterizedTest
    @MethodSource("provideMultiplicationData")
    public void testMultiplication(double number1, double number2, double expected) {
        double result = calculator.multiply(number1, number2);
        assertThat(result, closeTo(expected, DELTA));
    }

    @ParameterizedTest
    @MethodSource("provideDivisionData")
    public void testDivision(double number1, double number2, Object expected) {
        if ("Exception".equals(expected)) {
            // Ожидается исключение при делении на ноль
            assertThrows(
                    ArithmeticException.class,
                    () -> calculator.divide(number1, number2)
            );
        } else {
            double result = calculator.divide(number1, number2);
            assertThat(result, closeTo((double) expected, DELTA));
        }
    }

    // Методы предоставления данных

    private static Stream<Arguments> provideAdditionData() {
        return Stream.of(
                Arguments.of(1.0, 2.0, 3.0),
                Arguments.of(-0.5, 2.8, 2.3),
                Arguments.of(7.2, -1.1, 6.1),
                Arguments.of(-10.2, -5.1, -15.3),
                Arguments.of(9.12, 0.0, 9.12),
                Arguments.of(-1.75, 0.0, -1.75),
                Arguments.of(0.0, 21.0, 21.0),
                Arguments.of(0.0, -1.7, -1.7),
                Arguments.of(0.0, 0.0, 0.0)
        );
    }

    private static Stream<Arguments> provideSubtractionData() {
        return Stream.of(
                Arguments.of(1.0, 2.0, -1.0),
                Arguments.of(-0.5, 2.8, -3.3),
                Arguments.of(7.2, -1.1, 8.3),
                Arguments.of(-10.2, -5.1, -5.1),
                Arguments.of(9.12, 0.0, 9.12),
                Arguments.of(-1.75, 0.0, -1.75),
                Arguments.of(0.0, 21.0, -21.0),
                Arguments.of(0.0, -1.7, 1.7),
                Arguments.of(0.0, 0.0, 0.0)
        );
    }

    private static Stream<Arguments> provideMultiplicationData() {
        return Stream.of(
                Arguments.of(1.0, 2.0, 2.0),
                Arguments.of(-0.5, 2.8, -1.4),
                Arguments.of(7.2, -1.1, -7.92),
                Arguments.of(-10.2, -5.1, 52.02),
                Arguments.of(9.12, 0.0, 0.0),
                Arguments.of(-1.75, 0.0, 0.0),
                Arguments.of(0.0, 21.0, 0.0),
                Arguments.of(0.0, -1.7, 0.0),
                Arguments.of(0.0, 0.0, 0.0)
        );
    }

    private static Stream<Arguments> provideDivisionData() {
        return Stream.of(
                Arguments.of(1.0, 2.0, 0.0),
                Arguments.of(-0.5, 2.8, 0.0),
                Arguments.of(7.2, -1.1, -6.0),
                Arguments.of(-10.2, -5.1, 2.0),
                Arguments.of(9.12, 0.0, "Exception"),
                Arguments.of(-1.75, 0.0, "Exception"),
                Arguments.of(0.0, 21.0, 0.0),
                Arguments.of(0.0, -1.7, 0.0),
                Arguments.of(0.0, 0.0, "Exception")
        );
    }
}


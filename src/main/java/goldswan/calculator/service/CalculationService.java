// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package goldswan.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationService implements Calculator {

    @Override
    public double add(double number1, double number2) {
        return number1 + number2;
    }

    @Override
    public double subtract(double number1, double number2) {
        return number1 - number2;
    }

    @Override
    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

    // Целочисленное деление
    @Override
    public double divide(double number1, double number2) {
        if (number2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        return (double) ((long) (number1 / number2));
    }
}



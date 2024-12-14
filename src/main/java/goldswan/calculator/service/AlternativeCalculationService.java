// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package goldswan.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class AlternativeCalculationService implements Calculator {

    // Сложение через вычитание
    @Override
    public double add(double number1, double number2) {
        return number1 - (-number2);
    }

    // Вычитание через сложение
    @Override
    public double subtract(double number1, double number2) {
        return add(number1, -number2);
    }

    // Умножение через сложение в цикле
    @Override
    public double multiply(double number1, double number2) {
        double result = 0;
        double absNumber2 = Math.abs(number2);

        // Выделяем целую часть множителя
        long integerPart = (long) absNumber2;

        // Сложение целой части множителя
        for (int i = 0; i < integerPart; i++) {
            result = add(result, number1);
        }

        // Обработка дробной части множителя
        double fractionalPart = absNumber2 - integerPart;
        result = add(result, fractionalPart * number1);

        // Учет знака множителя
        return number2 < 0 ? -result : result;
    }

    // Деление через последовательное вычитание делителя из делимого
    @Override
    public double divide(double number1, double number2) {
        if (number2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        double result = 0;
        double absNumber1 = Math.abs(number1);
        double absNumber2 = Math.abs(number2);

        while (absNumber1 >= absNumber2) {
            absNumber1 = subtract(absNumber1, absNumber2);
            result = add(result, 1);
        }

        return (number1 < 0 ^ number2 < 0) ? -result : result; // Учет знаков через XOR
    }
}


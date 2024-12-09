package goldswan.calculator.service;

public interface Calculator {

    double add(double number1, double number2);

    double subtract(double number1, double number2);

    double multiply(double number1, double number2);

    // Целочисленное деление
    double divide(double number1, double number2);
}

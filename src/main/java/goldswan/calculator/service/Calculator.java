// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package goldswan.calculator.service;

public interface Calculator {

    double add(double number1, double number2);

    double subtract(double number1, double number2);

    double multiply(double number1, double number2);

    // Целочисленное деление
    double divide(double number1, double number2);
}

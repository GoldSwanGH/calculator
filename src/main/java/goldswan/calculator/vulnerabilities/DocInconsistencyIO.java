// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package goldswan.calculator.vulnerabilities;

public class DocInconsistencyIO {

    /**
     * Вычисляет площадь круга.
     *
     * @param width Ширина.
     * @param height Высота.
     * @return Длина периметра круга (целочисленная).
     */
    public double calculateArea(double radius) {
        // Реализация вычисляет площадь круга
        return Math.PI * radius * radius;
    }
}

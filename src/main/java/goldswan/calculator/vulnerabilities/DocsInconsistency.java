// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package goldswan.calculator.vulnerabilities;

public class DocsInconsistency {

    /**
     * Возвращает количество символов в переданной строке.
     *
     * @param input Входная строка.
     * @return Количество символов в строке.
     */
    public int countCharacters(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        // Реализация возвращает количество слов вместо символов
        return input.split("\\s+").length;
    }
}

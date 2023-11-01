package ru.sberbank.jd.lesson04;


import java.util.Scanner;

/**
 * Класс для хранения итоговых данных, который будут использоваться для формирования результата.
 * Наследуется от Arguments.
 */
public class OutputResult extends Arguments {
    /**
     * Поле для хранения кол-ва строк.
     */
    private int lines = 1;
    /**
     * Поле для хранения кол-ва букв без пробела.
     */
    private int words = 0;

    /**
     * Метод для чтения данных из файлов.
     *
     * @param nameFile получает имя файла.
     */
    public void read(String nameFile) {
        try (Scanner scanner = new Scanner(nameFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                updateWords(line);
                updateLine();
            }
        }
    }

    /**
     * Метод возвращает значение lines.
     *
     * @return кол-во линий.
     */
    public int getLines() {
        return lines;
    }

    /**
     * Метод возвращает значение words.
     *
     * @return кол-во букв без пробела.
     */

    public int getWords() {
        return words;
    }

    /**
     * Метод обновляет значение lines на 1.
     */
    public void updateLine() {
        lines++;
    }

    /**
     * Метод обновляет значение words на кол-во букв, поступившего слова.
     *
     * @param str содержит строку.
     */

    public void updateWords(String str) {
        words += str.replaceAll(" ", "").length();
    }
}

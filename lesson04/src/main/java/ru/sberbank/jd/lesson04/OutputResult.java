package ru.sberbank.jd.lesson04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
     * Поле для хранения кол-ва слов без пробела.
     */
    private int words = 0;

    /**
     * Метод для чтения данных из файлов.
     *
     * @param nameFile получает имя файла.
     */
    public void read(String nameFile) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(nameFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No found file!");
        }
        if (isCountWords()) {
            while (scanner.hasNext()) {
                scanner.next();
                updateWords();
            }
        }
        if (isCountLines()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(nameFile))) {
                while (reader.readLine() != null) {
                    updateLine();
                }

            } catch (IOException e) {
                e.getStackTrace();
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
     * Метод обновляет значение words на кол-во слов.
     */

    public void updateWords() {
        words++;
    }

    /**
     * Метод сбрасывает значение.
     */
    public void reload() {
        lines = 1;
        words = 0;
    }

    /**
     * Метод ищет присутствие неверного ключа.
     */
    public boolean searchArguments() {
        ArrayList<String> list = getFilePatch();
        for (String s : list) {

            if (s.charAt(0) == '-') {
                return true;
            }
        }
        return false;
    }
}

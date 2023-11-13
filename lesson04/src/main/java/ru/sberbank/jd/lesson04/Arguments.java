package ru.sberbank.jd.lesson04;

import java.util.ArrayList;

/**
 * Класс для хранения используемых аргументов.
 */
public class Arguments {
    /**
     * Поле о включение кол-ва строк в результат.
     */
    private boolean countLines = false;
    /**
     * Поле о включение кол-ва слов в результат.
     */
    private boolean countWords = false;
    /**
     * Поле для проверки вывода вспомогательной таблицы.
     */
    private boolean help = false;
    /**
     * Поле для вывода версии программы.
     */
    private boolean version = false;

    /**
     * Поле для хранения имени файлов.
     */
    private static final ArrayList<String> filePatch = new ArrayList<>();

    /**
     * Метод для включения отображения кол-ва строк в результат.
     */
    public void line() {
        countLines = true;
    }

    /**
     * Метод для включения отображения кол-ва слов в результат.
     */
    public void word() {
        countWords = true;
    }

    /**
     * Метод для включения вывода вспомогательной таблицы.
     */
    public void help() {
        help = true;
    }

    /**
     * Метод для включения вывода версии программы.
     */

    public void version() {
        version = true;
    }

    /**
     * Метод добавляет имя файла, для последующей работы с ним.
     */
    public void setFilePatch(String fileName) {
        filePatch.add(fileName);
    }

    /**
     * Метод возвращает значения поля.
     *
     * @return countLines.
     */

    public boolean isCountLines() {
        return countLines;
    }

    /**
     * Метод возвращает значения поля.
     *
     * @return countWords.
     */

    public boolean isCountWords() {
        return countWords;
    }

    /**
     * Метод возвращает значения поля.
     *
     * @return help.
     */

    public boolean isHelp() {
        return help;
    }

    /**
     * Метод возвращает значения поля.
     *
     * @return version.
     */

    public boolean isVersion() {
        return version;
    }

    /**
     * Метод возвращает динамический массив.
     *
     * @return значение filePatch.
     */

    public static ArrayList<String> getFilePatch() {
        return filePatch;
    }
}

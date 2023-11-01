package ru.sberbank.jd.lesson04;

/**
 * Класс выводит результат, исходя из анализа данных.
 */
public class ResultPrinter {

    /**
     * Поле - для обработки значения из класса.
     */
    OutputResult result;

    /**
     * Метод печатает информацию, исходя из запроса.
     * Если в ArrayList имеются значения, анализирует только их.
     *
     * @param result принимает объект OutputResult.
     */
    public void output(OutputResult result) {
        this.result = result;
        if (result.isVersion()) {
            version();
            return;
        } else if (result.isHelp()) {
            help();
            return;
        }
        if (Arguments.getFilePatch().isEmpty()) {
            if (result.isCountWords()) {
                System.out.print("\t" + words());
            }
            if (result.isCountLines()) {
                System.out.print("\t" + lines());
            }
        } else {
            int totalW = 0;
            int totalL = 0;
            for (int i = 0; i < Arguments.getFilePatch().size(); i++) {
                result.read(Arguments.getFilePatch().get(i));
                System.out.print("\t" + words());
                System.out.print("\t" + lines());
                totalL += lines();
                totalW += words();
                System.out.print("\t" + Arguments.getFilePatch().get(i));
                System.out.println();
            }
            System.out.print("\t" + totalW + "\t" + totalL + "\tTotal");
        }


    }

    /**
     * Метод печатает информацию значения help.
     */
    public void help() {
        System.out.println("\n"
                + "Программа частично дублирующая функционал Linux-программы `wc`\n"
                + "  -l           количество строк.\n"
                + "  -w           количество слов.\n"
                + "  --help       Справка по использованию программы.\n"
                + "  --version    Версия программы, фамилия разработчика.\n");
    }

    /**
     * Метод печатает информацию о версии.
     */
    public void version() {
        System.out.println(" WordCount version 2.0, by Meschcheryakov");
    }

    /**
     * Метод возвращает информацию lines.
     *
     * @return кол-во строк.
     */
    public int lines() {
        return result.getLines();
    }

    /**
     * Метод возвращает информацию words.
     *
     * @return кол-во букв.
     */
    public int words() {
        return result.getWords();
    }
}

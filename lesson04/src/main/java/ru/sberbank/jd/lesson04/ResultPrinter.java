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
            System.out.println(version());
            return;
        } else if (result.isHelp()) {
            System.out.println(help());
            return;
        }
        if (Arguments.getFilePatch().isEmpty()) {
            if (result.isCountWords()) {
                System.out.print("\t" + result.getWords());
            }
            if (result.isCountLines()) {
                System.out.print("\t" + result.getLines());
            }
        } else {
            int totalW = 0;
            int totalL = 0;
            for (int i = 0; i < Arguments.getFilePatch().size(); i++) {
                result.read(Arguments.getFilePatch().get(i));
                System.out.print("\t" + result.getWords());
                System.out.print("\t" + result.getLines());
                totalL += result.getLines();
                totalW += result.getWords();
                System.out.print("\t" + Arguments.getFilePatch().get(i));
                System.out.println();
                result.reload();
            }
            System.out.print("\t" + totalW + "\t" + totalL + "\tTotal");
        }
    }

    /**
     * Метод печатает информацию значения help.
     */
    public String help() {
        return "\n"
                + "Программа частично дублирующая функционал Linux-программы `wc`\n"
                + "  -l           количество строк.\n"
                + "  -w           количество слов.\n"
                + "  --help       Справка по использованию программы.\n"
                + "  --version    Версия программы, фамилия разработчика.\n";
    }

    /**
     * Метод печатает информацию о версии.
     */
    public String version() {
        return "WordCount version 2.0, by Meschcheryakov";
    }
}

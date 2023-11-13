package ru.sberbank.jd.lesson04;

/**
 * Поиск аргументов и передача в Argument, используя конструкцию Switch.
 */

public class ArgumentParser {

    /**
     * Поиск аргументов, используя конструкцию Switch.
     *
     * @param args получает массив строк.
     * @return возвращает объект arguments с включенными аргументами.
     */
    public Arguments parse(String[] args) {
        Arguments arguments = new Arguments();
        if (args.length == 0) {
            arguments.line();
            arguments.word();
        }
        for (String arg : args) {
            switch (arg) {
                case "-l":
                    arguments.line();
                    break;
                case "-w":
                    arguments.word();
                    break;
                case "--help":
                    arguments.help();
                    break;
                case "--version":
                    arguments.version();
                    break;
                case "-lw":
                case "-wl":
                    arguments.line();
                    arguments.word();
                    break;
                default:
                    arguments.setFilePatch(arg);
                    break;
            }
        }
        return arguments;
    }
}
package ru.sberbank.jd.lesson04;


import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс записывает входные данные и передает их OutputResult для дальнейшего анализа.
 */
public class OutputGenerator {
    /**
     * Поле для сбора информации и передачи.
     */
    private OutputResult result = new OutputResult();

    /**
     * Передача информации из arguments в OutputResult.
     *
     * @param arguments Первое значение.
     * @return Объект с готовыми данными.
     */

    public OutputResult generate(Arguments arguments) {
        if (arguments.isVersion()) {
            result.version();
            return result;
        } else if (arguments.isHelp()) {
            result.help();
            return result;
        }
        if (arguments.isCountWords()) {
            result.word();
        }
        if (arguments.isCountLines()) {
            result.line();
        }
        if (Arguments.getFilePatch().isEmpty()) {
            write();
            return result;
        } else {
            return result;
        }
    }

    /**
     * Считывает входные данные и обновляет значение updateWords и updateLine.
     */
    public boolean write() {
        String line;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                line = scanner.nextLine();
                result.updateWords(line);
                result.updateLine();
            }
        } catch (NoSuchElementException ex) {
            ex.getMessage();
        }
        return true;
    }
}
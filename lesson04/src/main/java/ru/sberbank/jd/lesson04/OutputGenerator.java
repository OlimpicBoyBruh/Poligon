package ru.sberbank.jd.lesson04;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        if (result.searchArguments()) {
            return result;
        }
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
            if (!arguments.isCountLines() && !arguments.isCountWords()) {
                result.word();
                result.line();
            }
            return result;
        }
    }

    /**
     * Считывает входные данные и обновляет значение updateWords и updateLine.
     */
    public boolean write() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int wordCount = 0;
        try {
            while ((line = reader.readLine()) != null) {
                result.updateLine();
                String[] words = line.trim().split(" ");
                wordCount += words.length;
            }
            result.setWords(wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
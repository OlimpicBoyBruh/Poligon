package ru.sberbank.jd.lesson10;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

/**
 * Класс для записи объекта в файл форматом JSON.
 */
public class SerializationJson<T> implements SerializationObject<T> {

    /**
     * Метод для записи объекта в файл.
     *
     * @param ob записываемый объект.
     */
    public void serialization(T ob) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("lesson10/src/main/resources/output/artist_by_country.json");
        try {
            objectMapper.writeValue(file, ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

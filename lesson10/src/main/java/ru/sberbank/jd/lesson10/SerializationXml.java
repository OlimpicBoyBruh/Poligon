package ru.sberbank.jd.lesson10;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

/**
 * Класс для записи объекта в файл форматом XML.
 */
public class SerializationXml<T> implements SerializationObject<T> {
    /**
     * Метод для записи объекта в файл форматом XML.
     *
     * @param ob записываемый объект.
     */
    public void serialization(T ob) {
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("lesson10/src/main/resources/output/artist_by_country.xml");
        try {
            mapper.writeValue(file, ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

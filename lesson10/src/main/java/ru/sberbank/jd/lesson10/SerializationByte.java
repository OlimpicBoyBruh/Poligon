package ru.sberbank.jd.lesson10;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для стандартной сериализации объекта и записи в файл.
 */
public class SerializationByte<T> implements SerializationObject<T> {
    /**
     * Метод записывает объект в файл.
     *
     * @param ob объект записи в файл.
     */
    public void serialization(T ob) {
        Path path = Paths.get("lesson10/src/main/resources/output/artist_by_country.serialized");
        try (OutputStream os = Files.newOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(ob);
        } catch (IOException e) {
            System.out.println("File no found!");
            System.exit(1);
        }

    }
}

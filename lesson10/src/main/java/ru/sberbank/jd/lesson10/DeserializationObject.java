package ru.sberbank.jd.lesson10;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import ru.sberbank.jd.lesson10.input.Catalog;

/**
 * Класс для десериализации в объекты.
 */
public class DeserializationObject<T> {
    /**
     * Метод десериализует объект Catalog из файла по указанному пути.
     *
     * @param catalog каталог дисков.
     * @return Catalog список CD.
     */
    public static Catalog deserialization(Catalog catalog, Path path) {
        try {

            XmlMapper xmlMapper = new XmlMapper();
            File file = new File(path.toUri());
            catalog = xmlMapper.readValue(file, Catalog.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalog;
    }
}

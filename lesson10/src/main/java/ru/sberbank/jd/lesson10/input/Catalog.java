package ru.sberbank.jd.lesson10.input;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

/**
 * Класс для хранения дисков.
 */
public class Catalog {
    /**
     * Поле для хранения дисков.
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CD")
    private List<Cd> cds;

    /**
     * Get метод для поля cds.
     *
     * @return возвращает List объектов.
     */
    public List<Cd> getCds() {
        return cds;
    }
}

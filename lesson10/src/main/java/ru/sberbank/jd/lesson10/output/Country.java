package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных об артистах в рамках страны.
 */
@JacksonXmlRootElement(localName = "Country")
public class Country implements Serializable {
    /**
     * Поле для хранения названия страны артистов.
     */
    @JacksonXmlProperty(isAttribute = true)
    private String name;

    /**
     * Поле для хранения артистов в указанной стране.
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Artist")
    private List<Artist> artists = new ArrayList<>();

    /**
     * Пустой конструктор.
     */
    public Country() {
    }

    /**
     * Конструктор для заполнения полей.
     *
     * @param name    название страны.
     * @param artists артисты указанной страны.
     */
    public Country(String name, List<Artist> artists) {
        this.name = name;
        this.artists = artists;
    }

    /**
     * Get метод для поля name.
     *
     * @return Get метод для возврата названия страны.
     */
    public String getName() {
        return name;
    }

    /**
     * Get метод для поля name.
     *
     * @return Get метод для List артистов.
     */
    public List<Artist> getArtists() {
        return artists;
    }

    /**
     * Get метод для поля artists.
     *
     * @return описание объекта в String объекте.
     */
    @Override
    public String toString() {
        return "Country{"
                + "name='" + name + '\''
                + ", artists=" + artists
                + '}';
    }
}

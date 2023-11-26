package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных об исполнителе.
 */
public class Artist implements Serializable {
    /**
     * Поле для хранения имени артиста.
     */
    @JacksonXmlProperty(localName = "Name")
    private String name;
    /**
     * Поле для хранения альбомов артиста.
     */
    @JacksonXmlProperty(localName = "Albums")
    private List<Album> albums = new ArrayList<>();

    /**
     * Пустой конструктор.
     */
    public Artist() {
    }

    /**
     * Поле для хранения альбомов артиста.
     *
     * @param name   имя артиста.
     * @param albums альбомы артиста.
     */
    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    /**
     * Get метод для поля name.
     *
     * @return String имя артиста.
     */
    public String getName() {
        return name;
    }

    /**
     * Get метод для поля albums.
     *
     * @return List альбомов артиста.
     */
    public List<Album> getAlbums() {
        return albums;
    }

    /**
     * Описание объекта.
     *
     * @return описание объекта в String объекте.
     */
    @Override
    public String toString() {
        return "Artist{"
                + "name='" + name + '\''
                + ", albums=" + albums
                + '}';
    }
}

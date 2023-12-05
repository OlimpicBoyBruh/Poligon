package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.Serializable;

/**
 * Класс для хранения данных об альбоме.
 */
public class Album implements Serializable {
    /**
     * Поле для хранения названия альбома.
     */
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    /**
     * Поле для хранения года выпуска альбома.
     */
    @JacksonXmlProperty(isAttribute = true)
    private int year;

    /**
     * Пустой конструктор.
     */
    public Album() {
    }

    /**
     * Конструктор для заполнения значения объектов.
     *
     * @param name имя альбома.
     * @param year год выпуска.
     */
    public Album(String name, int year) {
        this.name = name;
        this.year = year;
    }

    /**
     * Get метод для поля name.
     *
     * @return Get метод для возврата названия альбома.
     */
    public String getName() {
        return name;
    }

    /**
     * Get метод для поля year.
     *
     * @return Get метод для возврата года выпуска.
     */
    public int getYear() {
        return year;
    }

    /**
     * Описание объекта.
     *
     * @return описание объекта в String объекте.
     */
    @Override
    public String toString() {
        return "Album{"
                + "name='" + name + '\''
                + ", year=" + year
                + '}';
    }
}

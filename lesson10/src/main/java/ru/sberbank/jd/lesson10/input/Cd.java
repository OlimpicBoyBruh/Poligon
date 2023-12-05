package ru.sberbank.jd.lesson10.input;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Класс хранит описание диска.
 */
public class Cd {
    /**
     * Поле для хранения названия альбома.
     */
    @JacksonXmlProperty(localName = "TITLE")
    private String title;
    /**
     * Поле для хранения имени артиста.
     */
    @JacksonXmlProperty(localName = "ARTIST")
    private String artist;
    /**
     * Поле для хранения названия страны выпуска.
     */
    @JacksonXmlProperty(localName = "COUNTRY")
    private String country;
    /**
     * Поле для хранения названия компании.
     */
    @JacksonXmlProperty(localName = "COMPANY")
    private String company;
    /**
     * Поле для хранения цены диска.
     */
    @JacksonXmlProperty(localName = "PRICE")
    private double price;
    /**
     * Поле для хранения года выпуска.
     */
    @JacksonXmlProperty(localName = "YEAR")
    private int year;

    /**
     * Get метод для поля title.
     *
     * @return String название альбома.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get метод для поля artist.
     *
     * @return String имени артиста.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Get метод поля country.
     *
     * @return String название страны.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Get метод поля company.
     *
     * @return String название компании.
     */
    public String getCompany() {
        return company;
    }

    /**
     * Get метод поля price.
     *
     * @return double цена диска.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get метод поля year.
     *
     * @return int год выпуска диска.
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
        return "Cd{"
                + "title='" + title + '\''
                + ", artist='" + artist + '\''
                + ", country='" + country + '\''
                + ", company='" + company + '\''
                + ", price='" + price + '\''
                + ", year='" + year + '\''
                + '}';
    }
}

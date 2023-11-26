package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных по странам.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Registry implements Serializable {
    static final long serialVersionUID = 1L;

    /**
     * Поле кол-ва стран.
     */
    @JacksonXmlProperty(isAttribute = true)
    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("countryCount")
    private int countryCount;
    /**
     * Поле для хранения стран.
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Country")
    private List<Country> countries = new ArrayList<>();

    /**
     * Пустой конструктор.
     */
    public Registry() {
    }

    /**
     * Конструктор для заполнения полей.
     *
     * @param countries    список стран.
     * @param countryCount кол-во стран.
     */
    public Registry(List<Country> countries, int countryCount) {
        this.countryCount = countryCount;
        this.countries = countries;
    }

    /**
     * Get метод для поля countries.
     *
     * @return List стран.
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     * Get метод для поля countryCount.
     *
     * @return int кол-во стран.
     */
    public int getCountryCount() {
        return countryCount;
    }

    /**
     * Описание объекта.
     *
     * @return описание объекта в String объекте.
     */
    @Override
    public String toString() {
        return "Registry{"
                + "countryCount=" + countryCount
                + ", countries=" + countries
                + '}';
    }
}

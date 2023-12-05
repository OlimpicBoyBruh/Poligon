package ru.sberbank.jd.lesson10;


/**
 * Интерфейс для разной записи XML, JSON, byte.
 */
public interface SerializationObject<T> {
    /**
     * Метод для записи объекта в файл.
     *
     * @param ob Объект для записи.
     */
    void serialization(T ob);
}

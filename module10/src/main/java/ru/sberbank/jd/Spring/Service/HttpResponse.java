package ru.sberbank.jd.spring.service;

/**
 * Интерфейс, для get-запроса в заданному URL.
 */
public interface HttpResponse {
    /**
     * Делает get-запрос.
     *
     * @return возвращает ответ.
     */
    String callUrl();
}

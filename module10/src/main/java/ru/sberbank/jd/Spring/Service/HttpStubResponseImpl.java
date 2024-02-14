package ru.sberbank.jd.spring.service;

import ru.sberbank.jd.spring.config.model.AppProperties;


/**
 * Класс не совершает реальный get-запрос.
 */
public class HttpStubResponseImpl implements HttpResponse {
    /**
     * Содержит параметры application-dev.yaml.
     */
    private AppProperties appProperties;
    /**
     * Конструктор, реализует поля.
     *
     * @param appProperties параметры application-dev.yaml.
     */
    public HttpStubResponseImpl(AppProperties appProperties) {
        this.appProperties = appProperties;
    }
    /**
     * Метод не совершает реальный get-запрос, при необходимости можно создать контроллер.
     *
     * @return Возвращает необходимый ответ.
     */
    @Override
    public String callUrl() {
        return "Called stub " + appProperties.getUrl();
    }
}

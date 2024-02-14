package ru.sberbank.jd.spring.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import ru.sberbank.jd.spring.config.model.AppProperties;

/**
 * Класс, для реального get-запроса в заданному URL.
 */
@Slf4j
public class HttpResponseImpl implements HttpResponse {
    /**
     * Содержит параметры application-prom.yaml.
     */
    private AppProperties appProperties;
    /**
     * Объект для get-запроса.
     */
    @Setter
    private RestTemplate restTemplate;

    /**
     * Конструктор, реализует поля.
     *
     * @param appProperties параметры application-prom.yaml.
     */

    public HttpResponseImpl(AppProperties appProperties) {
        this.appProperties = appProperties;
        this.restTemplate = new RestTemplate();
    }
    /**
     * Делает Get-запрос, используя RestTemplate.
     *
     * @return ответ запроса.
     */
    @Override
    public String callUrl() {
        log.info("invoked url");
        return restTemplate.getForObject(appProperties.getUrl(), String.class);
    }

}

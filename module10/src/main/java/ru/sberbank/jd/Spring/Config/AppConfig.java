package ru.sberbank.jd.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.sberbank.jd.spring.config.model.AppProperties;
import ru.sberbank.jd.spring.service.HttpResponse;
import ru.sberbank.jd.spring.service.HttpResponseImpl;
import ru.sberbank.jd.spring.service.HttpStubResponseImpl;

/**
 * Класс для конфигурации Beans.
 */
@Configuration
@EnableConfigurationProperties(value = AppProperties.class)
@Slf4j
public class AppConfig {
    /**
     * Создает объект, передает параметры профиля prom.
     *
     * @param appProperties класс описывающий application-prom.yaml.
     * @return готорвый HttpResponse объект профиля prom для реального вызова get.
     */
    @Bean
    @Profile("prom")
    public HttpResponse httpResponseImpl(AppProperties appProperties) {
        log.info("AppProperties = " + appProperties.getUrl());

        return new HttpResponseImpl(appProperties);
    }

    /**
     * Создает объект, передает параметры профиля dev.
     *
     * @param appProperties класс описывающий application-dev.yaml.
     * @return готорвый HttpResponse объект профиля dev для stub вызова.
     */
    @Bean
    @Profile("dev")
    public HttpResponse httpStubResponseImpl(AppProperties appProperties) {
        log.info("AppProperties = " + appProperties.getUrl());
        return new HttpStubResponseImpl(appProperties);
    }
}

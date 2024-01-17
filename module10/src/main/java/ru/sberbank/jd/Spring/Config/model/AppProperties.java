package ru.sberbank.jd.spring.config.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Класс описывает параметры application-*.yaml.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "service")
public class AppProperties {
    /**
     * Поле содержащее url.
     */
    private String url;
}

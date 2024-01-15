package ru.sberbank.jd.Spring.Config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.sberbank.jd.Spring.Service.HttpResponse;
import ru.sberbank.jd.Spring.Service.HttpResponseImpl;

@Configuration
public class AppConfig {


    @Bean
    @Profile("prom")
    public HttpResponse httpResponseImpl(){
        HttpResponse  httpResponse = new HttpResponseImpl();
        return httpResponse;
    }




}

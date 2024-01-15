package ru.sberbank.jd.Spring.Service;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import ru.sberbank.jd.Spring.Config.UrlProperties;


@Slf4j
public class HttpResponseImpl implements HttpResponse {
    private RestTemplate restTemplate;

    private UrlProperties url;

    public HttpResponseImpl() {
        this.restTemplate = new RestTemplate();
        this.url = new UrlProperties();
    }
@PostConstruct
    @Override
    public String callHttp() {
        log.info("Invoked callHttp");
        return restTemplate.getForObject(url.getUrl(), String.class);
    }
}

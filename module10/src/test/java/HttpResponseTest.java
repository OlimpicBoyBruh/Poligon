import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import ru.sberbank.jd.spring.config.AppConfig;
import ru.sberbank.jd.spring.config.model.AppProperties;
import ru.sberbank.jd.spring.service.HttpResponse;
import ru.sberbank.jd.spring.service.HttpResponseImpl;
import ru.sberbank.jd.spring.service.HttpStubResponseImpl;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = AppConfig.class)
public class HttpResponseTest {

    @MockBean
    private AppProperties appProperties;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testRealCallUrl() {
        when(appProperties.getUrl()).thenReturn("https://httpbin.org/get");
        when(restTemplate.getForObject("https://httpbin.org/get", String.class)).thenReturn("Okay?");

        HttpResponseImpl httpResponse = new HttpResponseImpl(appProperties);
        httpResponse.setRestTemplate(restTemplate);

        assertEquals("Okay?", httpResponse.callUrl());
    }

    @Test
    public void testStubCallUrl() {
        when(appProperties.getUrl()).thenReturn("http://localhost:8080/module10");
        HttpResponse httpResponse = new HttpStubResponseImpl(appProperties);
        assertEquals("Called stub http://localhost:8080/module10", httpResponse.callUrl());
    }

}
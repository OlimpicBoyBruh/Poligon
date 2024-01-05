package ru.sberbank.jd.lesson14;

import com.fasterxml.jackson.databind.JsonNode;
import java.time.LocalDateTime;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Поставщик погоды.
 */
public class WeatherProvider {
    private WeatherInfo weatherInfo;
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Загрузите АКТУАЛЬНУЮ информацию о погоде из Интернета.
     * Вам следует вызвать GET http://api.openweathermap.org/data/2.5/weather?q={название города}&appid={ключ API}
     * Вам следует использовать шаблон Spring Rest для запросов на вызов
     *
     * @param city - город
     * @return информацию о погоде или null
     */
    public WeatherInfo get(String city) {
        if (city == null) {
            throw new IllegalArgumentException("City не может быть null!");
        }
        String apiKey = "52d143b895e36b3d46587971be1d45d8";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=";
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(5);
        JsonNode jsonNode;
        try {
            jsonNode = restTemplate.getForObject(url + city + "&appid=" + apiKey, JsonNode.class);
        } catch (HttpClientErrorException e) {
            System.out.println("Город не найден");
            return null;
        }
        weatherInfo = new WeatherInfo.WeatherInfoBuilder(city)
                .temperature(jsonNode.get("main").get("temp").asDouble())
                .pressure(jsonNode.get("main").get("pressure").asDouble())
                .windSpeed(jsonNode.get("wind").get("speed").asDouble())
                .expiryTime(expiryTime)
                .description(jsonNode.get("weather").get(0).get("description").asText())
                .feelsLikeTemperature(jsonNode.get("main").get("feels_like").asDouble())
                .shortDescription(jsonNode.get("weather").get(0).get("main").asText())
                .build();
        return weatherInfo;
    }
}

package ru.sberbank.jd.lesson14;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Кэш погоды.
 */
public class WeatherCache {
    /**
     * Ключ - город, погода - значение.
     */
    private final Map<String, WeatherInfo> cache = new HashMap<>();
    /**
     * Поставщик погоды.
     */
    private final WeatherProvider weatherProvider;

    /**
     * Конструктор.
     *
     * @param weatherProvider - поставщик погоды
     */
    public WeatherCache(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    /**
     * Получите АКТУАЛЬНУЮ информацию о погоде для текущего города или null, если текущий город не найден.
     * Если кэш не содержит информации о погоде ИЛИ содержит НЕ АКТУАЛЬНУЮ информацию, нам следует загрузить информацию
     * Если вы загружаете информацию о погоде, вам следует установить время истечения срока действия сейчас() плюс 5 мин
     * Если вы не можете загрузить информацию о погоде, удалите информацию о погоде для текущего города из кэша.
     *
     * @param city - город
     * @return актуальную информацию о погоде
     */
    public synchronized WeatherInfo getWeatherInfo(String city) {
        if (city == null) {
            return null;
        }
        if (!cache.containsKey(city)) {
            cache.put(city, weatherProvider.get(city));
            return cache.get(city);
        } else if (cache.get(city).getExpiryTime().isAfter(LocalDateTime.now())) {
            return cache.get(city);

        } else {
            removeWeatherInfo(city);
            cache.put(city, weatherProvider.get(city));
            return cache.get(city);
        }
    }

    /**
     * Удалите информацию о погоде из кэша.
     **/
    public synchronized void removeWeatherInfo(String city) {
        cache.remove(city);
    }
}


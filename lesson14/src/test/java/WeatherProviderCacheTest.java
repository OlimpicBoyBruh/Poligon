
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sberbank.jd.lesson14.WeatherCache;
import ru.sberbank.jd.lesson14.WeatherInfo;
import ru.sberbank.jd.lesson14.WeatherProvider;
import java.time.LocalDateTime;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class WeatherProviderCacheTest {

    private static WeatherProvider weatherProvider = mock(WeatherProvider.class);
    private static WeatherInfo weatherInfoAfter;
    private static WeatherInfo weatherInfoBefore;

    private static WeatherCache weatherCache;

    @BeforeClass
    public static void init() {
        weatherInfoAfter = new WeatherInfo.WeatherInfoBuilder("Moscow")
                .temperature(260.11)
                .shortDescription("Clouds")
                .description("overcast clouds")
                .feelsLikeTemperature(256.39)
                .expiryTime(LocalDateTime.now().minusMinutes(6))
                .windSpeed(5)
                .pressure(1042.0)
                .build();

        weatherInfoBefore = new WeatherInfo.WeatherInfoBuilder("Moscow")
                .temperature(100.10)
                .shortDescription("No clouds")
                .description("overcast clouds")
                .feelsLikeTemperature(256.39)
                .expiryTime(LocalDateTime.now())
                .windSpeed(1)
                .pressure(1042.0)
                .build();

        when(weatherProvider.get("Moscow")).thenReturn(weatherInfoAfter);
        weatherCache = new WeatherCache(weatherProvider);
    }

    @Test
    public void cacheEmptyTest() {
        WeatherInfo test = weatherCache.getWeatherInfo("Moscow");
        Assert.assertEquals("Moscow", test.getCity());
        Assert.assertEquals((int) 260.11, (int) test.getTemperature());
        Assert.assertEquals("Clouds", test.getShortDescription());
    }

    @Test
    public void updateInfoTest() {
        when(weatherProvider.get("Moscow")).thenReturn(weatherInfoBefore);

        WeatherInfo test = weatherCache.getWeatherInfo("Moscow");
        Assert.assertEquals("Moscow", test.getCity());
        Assert.assertEquals((int) 100.10, (int) test.getTemperature());
        Assert.assertEquals("No clouds", test.getShortDescription());
    }
}

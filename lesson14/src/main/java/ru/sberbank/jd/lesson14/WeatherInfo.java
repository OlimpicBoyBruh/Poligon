package ru.sberbank.jd.lesson14;

import java.time.LocalDateTime;

/**
 * Информация о погоде.
 */
public class WeatherInfo {

    private String city;

    /**
     * Краткое описание погоды.
     * * Например, "солнечно", "облачно", "дождь" и т.д
     */
    private String shortDescription;

    /**
     * Описание погоды.
     * Например, "разорванные облака", "сильный дождь" и т.д
     */
    private String description;

    /**
     * Температура.
     */
    private double temperature;

    /**
     * Температура, которая ощущается как.
     */
    private double feelsLikeTemperature;

    /**
     * Скорость ветра.
     */
    private double windSpeed;

    /**
     * Давление.
     */
    private double pressure;

    /**
     * Время истечения срока действия информации о погоде.
     * Если текущее время превышает время истечения срока действия, то текущая информация о погоде не актуальна!
     */
    private LocalDateTime expiryTime;

    /**
     * Конструктор.
     */
    private WeatherInfo(WeatherInfoBuilder builder) {
        this.city = builder.city;
        this.shortDescription = builder.shortDescription;
        this.description = builder.description;
        this.temperature = builder.temperature;
        this.feelsLikeTemperature = builder.feelsLikeTemperature;
        this.windSpeed = builder.windSpeed;
        this.pressure = builder.pressure;
        this.expiryTime = builder.expiryTime;
    }

    /**
     * Builder класс.
     */
    public static class WeatherInfoBuilder {
        private String city;
        private String shortDescription;
        private String description;
        private double temperature;
        private double feelsLikeTemperature;
        private double windSpeed;
        private double pressure;
        private LocalDateTime expiryTime;


        public WeatherInfoBuilder(String city) {
            this.city = city;
        }

        public WeatherInfoBuilder shortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
            return this;
        }

        public WeatherInfoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public WeatherInfoBuilder temperature(double temperature) {
            this.temperature = temperature;
            return this;
        }

        public WeatherInfoBuilder feelsLikeTemperature(double feelsLikeTemperature) {
            this.feelsLikeTemperature = feelsLikeTemperature;
            return this;
        }

        public WeatherInfoBuilder windSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public WeatherInfoBuilder pressure(double pressure) {
            this.pressure = pressure;
            return this;
        }

        public WeatherInfoBuilder expiryTime(LocalDateTime expiryTime) {
            this.expiryTime = expiryTime;
            return this;
        }

        public WeatherInfo build() {
            return new WeatherInfo(this);
        }
    }

    public String getCity() {
        return city;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getPressure() {
        return pressure;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    @Override
    public String toString() {
        return "WeatherInfo{"
                + "city='" + city + '\''
                + ", shortDescription='" + shortDescription + '\''
                + ", description='" + description + '\''
                + ", temperature=" + temperature
                + ", feelsLikeTemperature=" + feelsLikeTemperature
                + ", windSpeed=" + windSpeed
                + ", pressure=" + pressure
                + ", expiryTime=" + expiryTime
                + '}';
    }
}

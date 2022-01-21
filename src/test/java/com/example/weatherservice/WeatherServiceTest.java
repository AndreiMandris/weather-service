package com.example.weatherservice;

import com.example.weatherservice.application.WeatherService;
import com.example.weatherservice.domain.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;

    private static Weather buildWeather() {
        return Weather.builder()
                .temperature(24.5)
                .city("Rome")
                .country("IT")
                .base("stations")
                .visibility(10000)
                .cloudsAll(0)
                .windDeg(263)
                .humidity(65)
                .pressure(1011)
                .build();
    }

    @Test
    public void saveWeatherTest() {
        Weather weather = buildWeather();
        weatherService.saveWeather(weather);
        Assertions.assertTrue(weatherService.getAll().stream().anyMatch(weather::equals));
    }
}

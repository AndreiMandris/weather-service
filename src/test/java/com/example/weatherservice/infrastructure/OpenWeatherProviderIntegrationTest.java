package com.example.weatherservice.infrastructure;

import com.example.weatherservice.application.WeatherProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OpenWeatherProviderIntegrationTest {

    private final static String BERLIN = "Berlin";
    private final static String EXPECTED_COUNTRY = "DE";

    @Autowired
    private WeatherProvider weatherProvider;

    @Test
    public void openWeatherProvider() {
        Assertions.assertEquals(EXPECTED_COUNTRY, weatherProvider.getWeatherByCity(BERLIN).getCountry());
    }
}

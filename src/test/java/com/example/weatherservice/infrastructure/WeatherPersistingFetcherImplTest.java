package com.example.weatherservice.infrastructure;

import com.example.weatherservice.application.WeatherProvider;
import com.example.weatherservice.application.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class WeatherPersistingFetcherImplTest {

    private static final String CITY_NAME = "city";

    @InjectMocks
    private WeatherPersistingFetcherImpl weatherPersistingFetcher;

    @Mock
    private WeatherService weatherService;

    @Mock
    private WeatherProvider weatherProvider;

    @Test
    public void testSupplyAsyncWeatherDto() {
        weatherPersistingFetcher.fetchAndSaveWeather(CITY_NAME);
        Mockito.verify(weatherService).saveWeather(ArgumentMatchers.any());
        Mockito.verify(weatherProvider).getWeatherByCity(CITY_NAME);
    }
}
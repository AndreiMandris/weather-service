package com.example.weatherservice.infrastructure;

import com.example.weatherservice.application.WeatherProvider;
import com.example.weatherservice.application.WeatherService;
import com.example.weatherservice.infrastructure.deferredresult.DeferredResultManagerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.async.DeferredResult;

@RunWith(SpringRunner.class)
public class DeferredResultManagerImplTest {

    private static final String CITY_NAME = "city";

    @InjectMocks
    private DeferredResultManagerImpl deferredResultManager;

    @Mock
    private WeatherService weatherService;

    @Mock
    private WeatherProvider weatherProvider;

    @Test
    public void testSupplyAsyncWeatherDto() {
        deferredResultManager.saveAsyncWeatherDto(new DeferredResult<>(), CITY_NAME);
        Mockito.verify(weatherService).saveWeather(ArgumentMatchers.any());
        Mockito.verify(weatherProvider).getWeatherByCity(CITY_NAME);
    }
}
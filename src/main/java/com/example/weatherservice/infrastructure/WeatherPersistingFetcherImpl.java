package com.example.weatherservice.infrastructure;

import com.example.weatherservice.application.WeatherPersistingFetcher;
import com.example.weatherservice.application.WeatherProvider;
import com.example.weatherservice.application.WeatherService;
import com.example.weatherservice.domain.Weather;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherPersistingFetcherImpl implements WeatherPersistingFetcher {

    private final WeatherProvider weatherProvider;
    private final WeatherService weatherService;

    @Override
    public Weather fetchAndSaveWeather(String cityName) {
        Weather weather = weatherProvider.getWeatherByCity(cityName);
        return weatherService.saveWeather(weather);
    }
}

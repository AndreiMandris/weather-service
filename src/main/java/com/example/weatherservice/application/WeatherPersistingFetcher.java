package com.example.weatherservice.application;

import com.example.weatherservice.domain.Weather;

public interface WeatherPersistingFetcher {
    Weather fetchAndSaveWeather(String cityName);
}

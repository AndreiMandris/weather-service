package com.example.weatherservice.application;

import com.example.weatherservice.domain.Weather;

public interface WeatherService {
    void saveWeather(Weather weather);
}

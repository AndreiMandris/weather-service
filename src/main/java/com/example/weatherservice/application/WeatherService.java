package com.example.weatherservice.application;

import com.example.weatherservice.domain.Weather;

import java.util.List;

public interface WeatherService {
    Weather saveWeather(Weather weather);
}

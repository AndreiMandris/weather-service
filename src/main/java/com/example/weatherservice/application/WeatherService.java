package com.example.weatherservice.application;

import com.example.weatherservice.domain.Weather;

import java.util.List;

public interface WeatherService {
    void saveWeather(Weather weather);

    List<Weather> getAll();
}

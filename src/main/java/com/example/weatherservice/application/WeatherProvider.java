package com.example.weatherservice.application;

import com.example.weatherservice.domain.Weather;

public interface WeatherProvider {
    Weather getWeatherByCity(String city);
}

package com.example.weatherservice.infrastructure.weather;

import com.example.weatherservice.domain.Weather;
import com.example.weatherservice.infrastructure.weather.model.OpenWeatherResponse;

public class OpenWeatherMapper {

    public static Weather toWeather(OpenWeatherResponse openWeatherResponse) {
        return Weather.builder()
                .base(openWeatherResponse.getBase())
                .temperature(openWeatherResponse.getMain().getTemp())
                .pressure(openWeatherResponse.getMain().getPressure())
                .humidity(openWeatherResponse.getMain().getHumidity())
                .windSpeed(openWeatherResponse.getWind().getSpeed())
                .windDeg(openWeatherResponse.getWind().getDeg())
                .cloudsAll(openWeatherResponse.getClouds().getAll())
                .city(openWeatherResponse.getName())
                .country(openWeatherResponse.getSys().getCountry())
                .visibility(openWeatherResponse.getVisibility())
                .build();
    }
}

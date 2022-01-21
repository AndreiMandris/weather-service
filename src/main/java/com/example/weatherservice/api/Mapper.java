package com.example.weatherservice.api;

import com.example.weatherservice.domain.Weather;

public class Mapper {
    public static WeatherDto toWeatherDto(Weather weather) {
        return WeatherDto.builder()
                .base(weather.getBase())
                .temperature(weather.getTemperature())
                .pressure(weather.getPressure())
                .humidity(weather.getHumidity())
                .windSpeed(weather.getWindSpeed())
                .windDeg(weather.getWindDeg())
                .cloudsAll(weather.getCloudsAll())
                .cityName(weather.getCity())
                .country(weather.getCountry())
                .visibility(weather.getVisibility())
                .build();
    }
}

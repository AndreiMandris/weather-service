package com.example.weatherservice.infrastructure.persistence;

import com.example.weatherservice.application.WeatherService;
import com.example.weatherservice.domain.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;

    @Override
    @Transactional
    public void saveWeather(Weather weather) {
        weatherRepository.save(weather);
    }
}
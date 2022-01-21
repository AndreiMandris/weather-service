package com.example.weatherservice.infrastructure.persistence;

import com.example.weatherservice.application.WeatherService;
import com.example.weatherservice.domain.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;

    @Override
    @Transactional
    public Weather saveWeather(Weather weather) {
        return weatherRepository.save(weather);
    }
}

package com.example.weatherservice.api;

import com.example.weatherservice.application.WeatherPersistingFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherPersistingFetcher weatherPersistingFetcher;

    @GetMapping
    public ResponseEntity<WeatherDto> getWeatherByCity(@RequestParam("cityName") String cityName) {
        return new ResponseEntity<>(Mapper.toWeatherDto(weatherPersistingFetcher.fetchAndSaveWeather(cityName)), HttpStatus.OK);
    }
}

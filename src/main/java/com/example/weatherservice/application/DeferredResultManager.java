package com.example.weatherservice.application;

import com.example.weatherservice.api.WeatherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

public interface DeferredResultManager {
    void saveAsyncWeatherDto(DeferredResult<ResponseEntity<WeatherDto>> deferredResult, String cityName);
}

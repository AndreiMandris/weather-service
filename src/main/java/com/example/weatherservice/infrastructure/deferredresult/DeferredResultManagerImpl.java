package com.example.weatherservice.infrastructure.deferredresult;

import com.example.weatherservice.api.WeatherDto;
import com.example.weatherservice.application.DeferredResultManager;
import com.example.weatherservice.application.WeatherProvider;
import com.example.weatherservice.application.WeatherService;
import com.example.weatherservice.domain.Weather;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeferredResultManagerImpl implements DeferredResultManager {

    private final WeatherProvider weatherProvider;
    private final WeatherService weatherService;

    @Override
    public void saveAsyncWeatherDto(DeferredResult<ResponseEntity<WeatherDto>> deferredResult, String cityName) {
        try {
            Weather weather = weatherProvider.getWeatherByCity(cityName);
            weatherService.saveWeather(weather);
            deferredResult.setResult(ResponseEntity.ok(Mapper.toWeatherDto(weather)));
        } catch (Exception e) {
            log.error("Exception thrown while trying to retrieve weather data.", e);
            deferredResult.setErrorResult(e);
        }
    }
}

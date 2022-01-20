package com.example.weatherservice.infrastructure.weather;

import com.example.weatherservice.application.WeatherProvider;
import com.example.weatherservice.domain.Weather;
import com.example.weatherservice.infrastructure.weather.model.OpenWeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenWeatherProvider implements WeatherProvider {

    private final OpenWeatherConfigProp openWeatherConfigProp;
    private final RestTemplate restTemplate;

    @Override
    @Cacheable(value = "weather-cache", key = "#city")
    @Retryable(value = HttpServerErrorException.class,
            backoff = @Backoff(delay = 100L, maxDelay = 1500L, random = true, multiplier = 0.3))
    public Weather getWeatherByCity(String city) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(openWeatherConfigProp.getUrl())
                .queryParam("q", city)
                .queryParam("appid", openWeatherConfigProp.getKey())
                .queryParam("units", "metric");

        log.debug("Calling {} for {} city", openWeatherConfigProp.getUrl(), city);
        ResponseEntity<OpenWeatherResponse> response = restTemplate.getForEntity(
                uriComponentsBuilder.toUriString(),
                OpenWeatherResponse.class);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return OpenWeatherMapper.toWeather(response.getBody());
        } else {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

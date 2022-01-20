package com.example.weatherservice.infrastructure.weather;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "openweather.api")
public class OpenWeatherConfigProp {
    private String url;
    private String key;
}

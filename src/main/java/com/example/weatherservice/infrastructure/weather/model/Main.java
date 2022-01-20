
package com.example.weatherservice.infrastructure.weather.model;

import lombok.Data;

@Data
public class Main {
    private Double temp;
    private Integer pressure;
    private Integer humidity;
}

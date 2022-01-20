
package com.example.weatherservice.infrastructure.weather.model;

import lombok.Data;

@Data
public class OpenWeatherResponse {

    private String base;
    private Main main;
    private Integer visibility;
    private Wind wind;
    private Clouds clouds;
    private Long dt;
    private Sys sys;
    private String name;
    private Integer cod;
}

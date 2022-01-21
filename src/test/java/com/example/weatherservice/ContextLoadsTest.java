package com.example.weatherservice;

import com.example.weatherservice.api.WeatherController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContextLoadsTest {

    @Autowired
    private WeatherController weatherController;

    @Test
    void contextLoads() {
        Assert.notNull(weatherController, "WeatherController");
    }

}

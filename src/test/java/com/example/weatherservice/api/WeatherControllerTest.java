package com.example.weatherservice.api;

import com.example.weatherservice.application.WeatherPersistingFetcher;
import com.example.weatherservice.domain.Weather;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherPersistingFetcher weatherPersistingFetcher;

    private static Weather buildWeather() {
        return Weather.builder()
                .temperature(24.5)
                .city("Rome")
                .country("IT")
                .base("stations")
                .visibility(10000)
                .cloudsAll(0)
                .windDeg(263)
                .humidity(65)
                .pressure(1011)
                .build();
    }

    @Test
    public void shouldReturnOkResult() throws Exception {
        Mockito.doReturn(buildWeather()).when(weatherPersistingFetcher).fetchAndSaveWeather("Bucharest");
        this.mockMvc.perform(get("/api/v1/weather?cityName=Bucharest"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNotFoundResult() throws Exception {
        Mockito.doThrow(HttpClientErrorException.NotFound.class).when(weatherPersistingFetcher).fetchAndSaveWeather("Test");
        this.mockMvc.perform(get("/api/v1/weather?cityName=Test"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}

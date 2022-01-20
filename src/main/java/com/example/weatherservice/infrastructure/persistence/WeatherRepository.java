package com.example.weatherservice.infrastructure.persistence;

import com.example.weatherservice.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}

package com.example.weatherservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WEATHER")
public class Weather {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "TEMPERATURE")
    private Double temperature;

    @Column(name = "PRESSURE")
    private Integer pressure;

    @Column(name = "HUMIDITY")
    private Integer humidity;

    @Column(name = "BASE")
    private String base;

    @Column(name = "VISIBILITY")
    private Integer visibility;

    @Column(name = "WIND_SPEED")
    private Double windSpeed;

    @Column(name = "WIND_DEG")
    private Integer windDeg;

    @Column(name = "CLOUDS_ALL")
    private Integer cloudsAll;

    @CreationTimestamp
    @Column(name = "QUERIED_AT")
    private LocalDateTime queriedAt;
}

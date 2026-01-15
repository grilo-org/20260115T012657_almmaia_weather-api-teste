package com.alan.weather_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String description;
    private Double temperature;
    private LocalDateTime date;

    // Construtor vazio (obrigatório pro JPA)
    public WeatherEntity() {}

    // Construtor utilitário
    public WeatherEntity(String city, String description, Double temperature) {
        this.city = city;
        this.description = description;
        this.temperature = temperature;
        this.date = LocalDateTime.now();
    }

    // Getters
    public Long getId() { return id; }
    public String getCity() { return city; }
    public String getDescription() { return description; }
    public Double getTemperature() { return temperature; }
    public LocalDateTime getDate() { return date; }
}
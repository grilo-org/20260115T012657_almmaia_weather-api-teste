package com.alan.weather_api.controller;

import com.alan.weather_api.model.WeatherEntity;
import com.alan.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @PostMapping("/{cidade}")
    public WeatherEntity criarRegistroClima(@PathVariable String cidade) {
        return service.buscarEGuardarClima(cidade);
    }
}
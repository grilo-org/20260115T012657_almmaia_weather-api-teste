package com.alan.weather_api.service;

import com.alan.weather_api.dto.OpenWeatherDto;
import com.alan.weather_api.model.WeatherEntity;
import com.alan.weather_api.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    private WeatherRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherEntity buscarEGuardarClima(String cidade) {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=pt_br", 
                                   cidade, apiKey);
        
        try {
            OpenWeatherDto dadosApi = restTemplate.getForObject(url, OpenWeatherDto.class);

            if (dadosApi != null) {
                // Tenta pegar a descrição do clima, se houver
                String descricao = "";
                if (dadosApi.getWeather() != null && !dadosApi.getWeather().isEmpty()) {
                    descricao = dadosApi.getWeather().get(0).getDescription();
                }

                WeatherEntity novoClima = new WeatherEntity(
                    dadosApi.getName(),
                    descricao,
                    dadosApi.getMain().getTemp()
                );

                return repository.save(novoClima);
            }
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Erro ao buscar cidade: " + e.getMessage());
        }
        return null;
    }
}
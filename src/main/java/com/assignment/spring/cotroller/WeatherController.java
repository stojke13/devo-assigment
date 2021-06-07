package com.assignment.spring.cotroller;

import com.assignment.spring.dto.WeatherDTO;
import com.assignment.spring.helper.WeatherControllerHelper;
import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.model.WeatherEntity;
import com.assignment.spring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    private final RestTemplate restTemplate;

    private final WeatherService weatherService;

    private final WeatherControllerHelper helper;

    @Autowired
    public WeatherController(RestTemplate restTemplate, WeatherService weatherService, WeatherControllerHelper helper) {
        this.restTemplate = restTemplate;
        this.weatherService = weatherService;
        this.helper = helper;
    }


    @GetMapping("/weather/{city}")
    public WeatherDTO weather(@PathVariable String city) {
        String url=helper.buildURI(city);
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
        WeatherEntity entity=helper.mapper(response.getBody());
        return weatherService.SaveWeather(entity);
    }

}

package com.assignment.spring.service;

import com.assignment.spring.dto.WeatherDTO;
import com.assignment.spring.model.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

     private final WeatherRepository weatherRepository;

     @Autowired
     public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
     }

     public WeatherDTO SaveWeather(WeatherEntity weatherEntity){
          WeatherEntity savedEntity=weatherRepository.save(weatherEntity);
          WeatherDTO dto=new WeatherDTO(savedEntity.getId(), savedEntity.getCity(),savedEntity.getCountry(),savedEntity.getTemperature());
          return dto;
     }
}

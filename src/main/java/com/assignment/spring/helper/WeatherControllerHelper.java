package com.assignment.spring.helper;

import com.assignment.spring.Constants;
import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.model.WeatherEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherControllerHelper {

    public WeatherEntity mapper(WeatherResponse response) {
        WeatherEntity entity = new WeatherEntity();
        entity.setCity(response.getName());
        entity.setCountry(response.getSys().getCountry());
        entity.setTemperature(response.getMain().getTemp());
        return entity;
    }

    public String buildURI(String city){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(Constants.WEATHER_API_URL)
                .queryParam("q",city)
                .queryParam("APPID",System.getenv("API_KEY"));
        return builder.toUriString();
    }
}

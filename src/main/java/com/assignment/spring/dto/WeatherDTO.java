package com.assignment.spring.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDTO {
    private UUID id;
    private String city;
    private String country;
    private Double temperature;
}

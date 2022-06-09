package com.shinbae.weathermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {

    private long id;

    private String main;

    private String description;

    private String icon;
}

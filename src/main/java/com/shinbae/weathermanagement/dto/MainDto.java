package com.shinbae.weathermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainDto {

    private double temp;

    private double feels_like;

    private double temp_min;

    private double temp_max;

    private int pressure;

    private int humidity;
}

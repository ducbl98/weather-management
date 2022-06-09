package com.shinbae.weathermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WindDto {

    private double speed;

    private int deg;

    private double gust;
}

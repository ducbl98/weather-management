package com.shinbae.weathermanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDto {

    private long dt;

    private long visibility;

    private String base;

    private long id;

    private int cod;

    private String name;

    private int timezone;

    private CoordDto coord;

    private CloudsDto clouds;

    private SysDto sys;

    private Set<WeatherDto> weather;

    private WindDto wind;

    private MainDto main;

}

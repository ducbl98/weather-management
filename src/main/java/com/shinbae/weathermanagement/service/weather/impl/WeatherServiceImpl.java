package com.shinbae.weathermanagement.service.weather.impl;

import com.shinbae.weathermanagement.entity.WeatherEntity;
import com.shinbae.weathermanagement.repository.WeatherRepository;
import com.shinbae.weathermanagement.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public WeatherEntity createWeather(WeatherEntity weather) {
        return weatherRepository.save(weather);
    }
}

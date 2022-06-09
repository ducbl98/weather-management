package com.shinbae.weathermanagement.service.city.impl;

import com.shinbae.weathermanagement.entity.CityEntity;
import com.shinbae.weathermanagement.repository.CityRepository;
import com.shinbae.weathermanagement.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public CityEntity createCity(CityEntity city) {
        return cityRepository.save(city);
    }
}

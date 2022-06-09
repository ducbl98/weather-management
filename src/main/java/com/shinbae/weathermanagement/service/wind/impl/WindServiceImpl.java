package com.shinbae.weathermanagement.service.wind.impl;

import com.shinbae.weathermanagement.entity.WindEntity;
import com.shinbae.weathermanagement.repository.WindRepository;
import com.shinbae.weathermanagement.service.wind.WindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WindServiceImpl implements WindService {

    @Autowired
    private WindRepository windRepository;

    @Override
    public WindEntity createWind(WindEntity wind) {
        return windRepository.save(wind);
    }
}

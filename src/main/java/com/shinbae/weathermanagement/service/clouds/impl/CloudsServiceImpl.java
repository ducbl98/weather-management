package com.shinbae.weathermanagement.service.clouds.impl;

import com.shinbae.weathermanagement.entity.CloudsEntity;
import com.shinbae.weathermanagement.repository.CloudsRepository;
import com.shinbae.weathermanagement.service.clouds.CloudsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloudsServiceImpl implements CloudsService {

    @Autowired
    private CloudsRepository cloudsRepository;

    @Override
    public CloudsEntity createClouds(CloudsEntity clouds) {
        return cloudsRepository.save(clouds);
    }
}

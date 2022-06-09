package com.shinbae.weathermanagement.service.main.impl;

import com.shinbae.weathermanagement.entity.MainEntity;
import com.shinbae.weathermanagement.repository.MainRepository;
import com.shinbae.weathermanagement.service.main.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private MainRepository mainRepository;

    @Override
    public MainEntity createMain(MainEntity main) {
        return this.mainRepository.save(main);
    }
}

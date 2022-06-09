package com.shinbae.weathermanagement.service.coord.impl;

import com.shinbae.weathermanagement.entity.CoordEntity;
import com.shinbae.weathermanagement.repository.CoordRepository;
import com.shinbae.weathermanagement.service.coord.CoordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordServiceImpl implements CoordService {

    @Autowired
    private CoordRepository coordRepository;

    @Override
    public CoordEntity createCoord(CoordEntity coord) {
        return this.coordRepository.save(coord);
    }
}

package com.shinbae.weathermanagement.service.record.impl;

import com.shinbae.weathermanagement.entity.RecordEntity;
import com.shinbae.weathermanagement.repository.RecordRepository;
import com.shinbae.weathermanagement.service.record.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public RecordEntity createRecord(RecordEntity record) {
        return recordRepository.save(record);
    }
}

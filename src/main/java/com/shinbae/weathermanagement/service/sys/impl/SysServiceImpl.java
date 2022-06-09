package com.shinbae.weathermanagement.service.sys.impl;

import com.shinbae.weathermanagement.entity.SysEntity;
import com.shinbae.weathermanagement.repository.SysRepository;
import com.shinbae.weathermanagement.service.sys.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private SysRepository sysRepository;

    @Override
    public SysEntity createSys(SysEntity sys) {
        return sysRepository.save(sys);
    }
}

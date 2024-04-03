package com.carproject.service.impl;

import com.carproject.mapper.WCMPMapper;
import com.carproject.pojo.DetailedCarData;
import com.carproject.service.WCMPDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WCMPDataServiceImpl implements WCMPDataService {
    @Autowired
    WCMPMapper mapper;

    @Override
    public DetailedCarData getDetailedData(String carNumber) {
        return mapper.getDetailedData(carNumber);
    }


}

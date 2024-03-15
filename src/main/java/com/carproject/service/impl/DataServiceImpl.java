package com.carproject.service.impl;

import com.carproject.mapper.DataMapper;
import com.carproject.pojo.CarDate;
import com.carproject.pojo.DetailedCarData;
import com.carproject.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataMapper dataMapper;

    @Override
    public DetailedCarData getData(String carNumber) {
        return dataMapper.getData(carNumber);

    }

    @Override
    public List<CarDate> getCarData() {
        return dataMapper.getCarData();
    }
}

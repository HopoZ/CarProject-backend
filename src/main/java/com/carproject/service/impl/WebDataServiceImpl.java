package com.carproject.service.impl;

import com.carproject.mapper.WebDataMapper;
import com.carproject.pojo.CarDate;
import com.carproject.pojo.DetailedCarData;
import com.carproject.pojo.RegisterRequest;
import com.carproject.service.WebDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebDataServiceImpl implements WebDataService {

    @Autowired
    WebDataMapper webDataMapper;

    @Override
    public DetailedCarData getDetailedData(String carNumber) {
        return webDataMapper.getDetailedData(carNumber);
    }

    @Override
    public List<CarDate> carDataList() {
        return webDataMapper.carDataList();
    }

    @Override
    public void registerCar(RegisterRequest carNumber) {
        webDataMapper.registerCar(carNumber);
    }

    @Override
    public void deleteData(String carNumber) {
        webDataMapper.deleteData(carNumber);
    }
}

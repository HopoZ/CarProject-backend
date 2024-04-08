package com.carproject.service;

import com.carproject.pojo.CarDate;
import com.carproject.pojo.DetailedCarData;
import com.carproject.pojo.RegisterRequest;
import com.carproject.pojo.TemperatureLog;

import java.util.List;

public interface WebDataService {
    DetailedCarData getDetailedData(String carNumber);
    List<CarDate> carDataList();
    void registerCar(RegisterRequest carNumber);
    void deleteData(String carNumber);
    List<TemperatureLog> getTemperatureLog(String carNumber);
}

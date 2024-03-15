package com.carproject.service;

import com.carproject.pojo.CarDate;
import com.carproject.pojo.DetailedCarData;

import java.util.List;

public interface DataService {
    DetailedCarData getData(String carNumber);
    List<CarDate> getCarData();
}

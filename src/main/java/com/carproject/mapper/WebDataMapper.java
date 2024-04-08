package com.carproject.mapper;

import com.carproject.pojo.CarDate;
import com.carproject.pojo.DetailedCarData;
import com.carproject.pojo.RegisterRequest;
import com.carproject.pojo.TemperatureLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebDataMapper {
    DetailedCarData getDetailedData(String carNumber);
    List<CarDate> carDataList();
    void registerCar(RegisterRequest carNum);
    void deleteData(String carNumber);
    List<TemperatureLog> getTemperatureLog(String carNumber);

}

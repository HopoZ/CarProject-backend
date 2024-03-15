package com.carproject.mapper;

import com.carproject.pojo.CarDate;
import com.carproject.pojo.DetailedCarData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataMapper {
    DetailedCarData getData(String carNumber);
    List<CarDate> getCarData();
}

package com.carproject.mapper;

import com.carproject.pojo.DetailedCarData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WCMPMapper {
    DetailedCarData getDetailedData(String carNumber);

}

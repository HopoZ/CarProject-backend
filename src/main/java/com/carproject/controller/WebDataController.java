package com.carproject.controller;

import com.carproject.pojo.CarDate;
import com.carproject.pojo.DetailedCarData;
import com.carproject.pojo.RegisterRequest;
import com.carproject.service.WebDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class WebDataController {

    @Autowired
    private WebDataService webDataService;

    /**
     * 详细数据查询接口
     * @param carNumber 车牌号
     * @return 车辆信息
     */
    @GetMapping ("/getDetailedData")
    @CrossOrigin(origins = "http://localhost:8080")
    public DetailedCarData getDetailedData(String carNumber) {
        return webDataService.getDetailedData(carNumber);
    }

    @GetMapping ("/carDataList")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<CarDate> getCarData() {
        return webDataService.carDataList();
    }


    @GetMapping ("/registerCar ")
    @CrossOrigin(origins = "http://localhost:8080")
    public void registerCar(@RequestBody RegisterRequest carNumber) {
        webDataService.registerCar(carNumber);
    }
}
package com.carproject.controller;

import com.carproject.pojo.CarDate;
import com.carproject.pojo.DetailedCarData;
import com.carproject.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping ("/getData")
    public DetailedCarData getData(String carNumber) {
        return dataService.getData(carNumber);
    }

    @GetMapping ("/getCarData")
    public List<CarDate> getCarData() {
        return dataService.getCarData();
    }

}

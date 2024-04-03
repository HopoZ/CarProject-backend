package com.carproject.controller;

import com.carproject.pojo.DetailedCarData;
import com.carproject.service.WCMPDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WCMP")
public class WCMPDataController {
    @Autowired
    private WCMPDataService service;
    /**
     * 详细数据查询接口
     * @param carNumber 车牌号
     * @return 车辆信息
     */
    @GetMapping("/getDetailedData")
    public DetailedCarData getDetailedData(@RequestParam String carNumber) {
        return service.getDetailedData(carNumber);
    }

}

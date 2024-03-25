package com.carproject.controller;

import com.carproject.pojo.CarDate;
import com.carproject.pojo.DetailedCarData;
import com.carproject.pojo.RegisterRequest;
import com.carproject.service.WebDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/web")
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
    public DetailedCarData getDetailedData(@RequestParam String carNumber) {
        return webDataService.getDetailedData(carNumber);
    }

    /**
     * 车辆信息列表
     * @return 车辆信息
     */
    @GetMapping ("/carDataList")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<CarDate> getCarData() {
        return webDataService.carDataList();
    }

    /**
     * 注册车辆
     * @param carNumber 车牌号
     */
    @PostMapping ("/registerCar")
    @CrossOrigin(origins = "http://localhost:8080")
    public Map<String, Object> registerCar(@RequestBody RegisterRequest carNumber) {
        Map<String, Object> map = new HashMap<>();
        try{
            webDataService.registerCar(carNumber);
            map.put("state", true);
            map.put("msg", "注册成功");
        }catch (Exception e) {
            map.put("state", false);
            map.put("msg", "注册失败：该车已注册");
        }
        return map;
    }
}

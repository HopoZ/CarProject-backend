package com.carproject.controller;

import com.carproject.pojo.CarDate;
import com.carproject.pojo.DetailedCarData;
import com.carproject.pojo.RegisterRequest;
import com.carproject.pojo.TemperatureLog;
import com.carproject.service.WebDataService;
import com.carproject.util.Result;
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
     *
     * @param carNumber 车牌号
     * @return 车辆信息
     */
    @GetMapping("/getDetailedData")
    public DetailedCarData getDetailedData(@RequestParam String carNumber) {
        return webDataService.getDetailedData(carNumber);
    }

    /**
     * 车辆信息列表
     *
     * @return 车辆信息
     */
    @GetMapping("/carDataList")
    public List<CarDate> getCarData() {
        return webDataService.carDataList();
    }

    /**
     * 注册车辆
     *
     * @param carNumber 车牌号
     */
    @PostMapping("/registerCar")
    public Map<String, Object> registerCar(@RequestBody RegisterRequest carNumber) {
        Map<String, Object> map = new HashMap<>();
        try {
            webDataService.registerCar(carNumber);
            map.put("state", true);
            map.put("msg", "注册成功");
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", "注册失败：该车已注册");
        }
        return map;
    }

    /**
     * 删除车辆信息
     *
     * @param carNumber 车牌号
     * @return 结果
     */
    @GetMapping("/delete")
    public Result deleteData(@RequestParam String carNumber) {
//        try {
        webDataService.deleteData(carNumber);
//        }catch (Exception e){
//            return Result.error("err");
//        }
        if(webDataService.getDetailedData(carNumber) != null)
            return Result.error("err");
        return Result.success();
    }

    /**
     * 获取温度日志
     * @param carNumber 车牌号
     * @return 温度日志
     */
    @GetMapping("/getTemperatureLog")
    public Result getTemperatureLog(@RequestParam String carNumber) {
        List<TemperatureLog> result = webDataService.getTemperatureLog(carNumber);
        if (result.size() != 0)
            return Result.success(result);
        else{
            return Result.error("no temperature data");
        }
    }
}

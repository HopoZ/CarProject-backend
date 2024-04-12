package com.carproject.pojo;

import lombok.Data;

@Data
public class TemperatureLog {
    String carNumber;
    Float temperature;
    String datetime;
}

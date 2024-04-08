package com.carproject.pojo;

import lombok.Data;

@Data
public class TemperatureLog {
    Integer carNumber;
    Float temperature;
    String datetime;
}

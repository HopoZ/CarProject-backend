package com.carproject.pojo;

import lombok.Data;

@Data
public class DetailedCarData {
    String carNumber;
    String isTired;
    String isDrunk;
    String drunkDrivingPro;
    Float alcoholConc;
    Float temperature;
    Float latitude;
    Float longitude;

}

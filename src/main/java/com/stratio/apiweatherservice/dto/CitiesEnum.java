package com.stratio.apiweatherservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum  CitiesEnum {

    madrid("20766273"),
    barcelona("20753692"),
    bilbao("20754542"),
    seville("20774508");

    private String code;
}

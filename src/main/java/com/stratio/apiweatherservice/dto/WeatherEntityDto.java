package com.stratio.apiweatherservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEntityDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long auditId;

    private String desCity;

    private String desDate;

    private String desDay;

    private String desHigh;

    private String desLow;

    private String desText;
}

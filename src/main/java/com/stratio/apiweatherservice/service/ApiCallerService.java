package com.stratio.apiweatherservice.service;

import com.stratio.apiweatherservice.dto.WeatherEntityDto;
import com.stratio.apiweatherservice.dto.WeatherResponseDto;

import java.util.List;

public interface ApiCallerService {

    WeatherResponseDto getPrediction(String city);

    List<WeatherEntityDto> getPredictionHistory(String city, String prediction);
}

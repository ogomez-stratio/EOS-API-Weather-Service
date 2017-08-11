package com.stratio.apiweatherservice.controller;

import com.stratio.apiweatherservice.dto.WeatherEntityDto;
import com.stratio.apiweatherservice.dto.WeatherResponseDto;
import com.stratio.apiweatherservice.service.ApiCallerService;
import com.stratio.apiweatherservice.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiWeatherController {

    private final ApiCallerService apiCallerService;

    @GetMapping("weather/{city}")
    @ApiOperation(value = "Given a city Get weather prediction for next week")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Standard response for successful HTTP requests"),
            @ApiResponse(code = 404, message = "User does not exist or is missing city")
    })
    public ResponseEntity<WeatherResponseDto> getWeatherByCity(
            @ApiParam(required = true, value = "City we want the weather prediction",
                    allowableValues = "madrid, barcelona, bilbao, seville" )
            @PathVariable String city) throws HttpClientErrorException {

        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(apiCallerService.getPrediction(city)));
    }

    @GetMapping("weather/history/city/{city}/prediction/{prediction}")
    @ApiOperation(value = "Given a city and the text of a prediction get weather prediction stored in audit database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Standard response for successful HTTP requests"),
            @ApiResponse(code = 404, message = "User does not exist or is missing city")
    })
    public ResponseEntity<List<WeatherEntityDto>> getPredictionHistory(
            @ApiParam(required = true, value = "City we want to request historic weather prediction")
            @PathVariable String city,
            @ApiParam(required = true, value = "Type of prediction we want to filter (sunny,cloudy,rain,..) ")
            @PathVariable String prediction
    ) throws HttpClientErrorException {

        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(apiCallerService.getPredictionHistory(city, prediction)));
    }
    public ApiWeatherController(ApiCallerService apiCallerService) {
        this.apiCallerService = apiCallerService;
    }
}

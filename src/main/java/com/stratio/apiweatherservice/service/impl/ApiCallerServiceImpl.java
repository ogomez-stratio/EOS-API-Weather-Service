package com.stratio.apiweatherservice.service.impl;

import com.stratio.apiweatherservice.component.DiscoveryClient;
import com.stratio.apiweatherservice.dto.WeatherEntityDto;
import com.stratio.apiweatherservice.dto.WeatherResponseDto;
import com.stratio.apiweatherservice.service.ApiCallerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
class ApiCallerServiceImpl implements ApiCallerService {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    @Value("${dependencies.weatherServiceId}")
    private String weatherServiceId;

    @Value("${service.getHistoricUri}")
    private String getHistoricUri;

    @Value(("${service.getPredictionUri}"))
    private String getPredictionUri;


    @Override
    public WeatherResponseDto getPrediction(String city)
             throws HttpClientErrorException{
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "application/json");

        HttpEntity<Object> request = new HttpEntity(null, httpHeaders);

        String[] parameters ={city};

        ResponseEntity<WeatherResponseDto> result = restTemplate.exchange(
                discoveryClient.getServiceUri(weatherServiceId)+getPredictionUri,
                HttpMethod.GET,
                request,
                WeatherResponseDto.class,
                parameters);

        return result.getBody();
    }

    @Override
    public List<WeatherEntityDto> getPredictionHistory(String city, String prediction)
            throws HttpClientErrorException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "application/json");

        HttpEntity<Object> request = new HttpEntity(null, httpHeaders);

        String[] parameters ={city,prediction};

        ResponseEntity<WeatherEntityDto[]> result = restTemplate.exchange(
                discoveryClient.getServiceUri(weatherServiceId)+getHistoricUri,
                HttpMethod.GET,
                request,
                WeatherEntityDto[].class,
                parameters);

        return Arrays.asList(result.getBody());
    }

    ApiCallerServiceImpl(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }
}

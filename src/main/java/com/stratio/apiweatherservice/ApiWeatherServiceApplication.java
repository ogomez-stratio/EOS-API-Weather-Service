package com.stratio.apiweatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiWeatherServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiWeatherServiceApplication.class, args);
    }
}

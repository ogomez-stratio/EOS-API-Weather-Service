package com.stratio.apiweatherservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="service")
@Data
public class ServiceConfig {

    private String getHistoricUri;
    private String getPredictionUri;
}

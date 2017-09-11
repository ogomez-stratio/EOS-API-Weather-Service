package com.stratio.apiweatherservice.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "dcos-cluster")
@Data
public class DcosConfig {
    private String domain;
    private String port;
}
package com.stratio.apiweatherservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "dependencies")
@Data
public class DependenciesConfig {

    private String weatherServiceId;
    private String weatherServicePort;
}

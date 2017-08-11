package com.stratio.apiweatherservice.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DiscoveryClient {

    private final ConsulDiscoveryClient consulDiscoveryClient;

    public String getServiceUri(String serviceId) {
        log.info("Calling ["+serviceId+"] service");
        List<ServiceInstance> list = consulDiscoveryClient.getInstances(serviceId);

        if(list != null && !list.isEmpty()) {
            log.info("Instances of ["+serviceId+"] found: "+list.toString());
            return list.get(0).getUri().toString();
        }
        return null;
    }

    public DiscoveryClient(ConsulDiscoveryClient consulDiscoveryClient) {
        this.consulDiscoveryClient = consulDiscoveryClient;
    }
}

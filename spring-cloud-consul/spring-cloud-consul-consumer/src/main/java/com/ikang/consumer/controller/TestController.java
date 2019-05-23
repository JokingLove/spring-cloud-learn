package com.ikang.consumer.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    private final LoadBalancerClient loadBalancerClient;
    private final RestTemplate restTemplate;

    public TestController(LoadBalancerClient loadBalancerClient, RestTemplate restTemplate) {
        this.loadBalancerClient = loadBalancerClient;
        this.restTemplate = restTemplate;
    }


    @GetMapping("/say")
    public String hello() {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("provider");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(), serviceInstance.getPort()) + "/hello";
        return restTemplate.getForObject("http://provider/hello", String.class);
    }
}

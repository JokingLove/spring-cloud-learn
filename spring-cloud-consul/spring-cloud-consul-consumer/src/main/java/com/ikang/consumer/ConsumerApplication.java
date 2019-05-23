package com.ikang.consumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public IRule rule() {
		return new RandomRule();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}

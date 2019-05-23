package com.ikang.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {

	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		return "我是服务提供者：" + request.getServerPort();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

}

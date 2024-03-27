package com.msvc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewaySerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaySerivceApplication.class, args);
	}

}

package com.msvc.car.msvccar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsvcCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcCarApplication.class, args);
	}

}

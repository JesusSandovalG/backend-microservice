package com.service.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class MicroserviceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceStoreApplication.class, args);
	}

}

package com.service.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceVehicleApplication.class, args);
	}

}

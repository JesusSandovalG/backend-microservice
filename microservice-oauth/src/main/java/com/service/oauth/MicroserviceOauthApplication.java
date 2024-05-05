package com.service.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOauthApplication.class, args);
	}

}

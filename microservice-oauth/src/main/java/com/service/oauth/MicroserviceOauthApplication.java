package com.service.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroserviceOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOauthApplication.class, args);
	}

}

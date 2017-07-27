package com.xa.gtsserver.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class GTSServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GTSServerApplication.class, args);
	}
}

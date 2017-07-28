package com.xa.gtsserver.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.xa.gtsserver.api"})
@ComponentScan(basePackages={"com.xa.gtsserver"})
public class GTSServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GTSServerApplication.class, args);
	}
}

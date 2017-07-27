package com.xa.gtsorderserver.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.xa.gtsorderserver.api"})
@ComponentScan(basePackages={"com.xa.gtsorderserver"})
public class GTSOrderServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GTSOrderServerApplication.class, args);
	}
}

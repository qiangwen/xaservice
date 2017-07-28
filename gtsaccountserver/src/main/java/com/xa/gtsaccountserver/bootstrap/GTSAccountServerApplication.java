package com.xa.gtsaccountserver.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.xa.gtsaccountserver.api"})
@ComponentScan(basePackages={"com.xa.gtsaccountserver"})
public class GTSAccountServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GTSAccountServerApplication.class, args);
	}
}

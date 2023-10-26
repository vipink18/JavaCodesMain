package com.yu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class YuEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(YuEurekaServerApplication.class, args);
	}

}

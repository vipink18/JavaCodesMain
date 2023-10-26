package com.capg.GasBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GasBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasBookingApplication.class, args);
	}

}

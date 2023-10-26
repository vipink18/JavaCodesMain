package com.capg.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "BOOKING-SERVICE", url = "localhost:2051/booking")
public interface GasBookingServiceFeign {

}

package com.capg.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "CUSTOMER-SERVICE", url = "localhost:2050/customer")
public interface CustomerServiceFeign {

}

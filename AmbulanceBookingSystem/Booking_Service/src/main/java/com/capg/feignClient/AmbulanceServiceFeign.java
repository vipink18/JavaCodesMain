package com.capg.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.entity.Ambulance;

@FeignClient(name = "AMBULANCE-SERVICE", url = "localhost:2024/api/v1/ambulance")
public interface AmbulanceServiceFeign {
	
	@GetMapping(value = "/findAmbulanceById/{ambulanceId}")
	Ambulance findAmbulanceById(@PathVariable String ambulanceId);

}

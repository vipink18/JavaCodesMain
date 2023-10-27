package com.capg.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.util.Ambulance;

@FeignClient(name = "ambulance-service", url = "localhost:2024/api/v1/ambulance")
public interface AmbulanceServiceFeign {

	@GetMapping(value = "/getAllAmbulanceByLocation/{ambulanceLocation}")
	public List<Ambulance> getAllAmbulanceByLocation(@PathVariable String ambulanceLocation);
}

package com.capg.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.util.Hospital;

@FeignClient(name = "hospital-service", url = "localhost:1998/api/v1/hospital")
public interface HospitalServiceFeign {

	@GetMapping("/getHospitalByHospitalLocation/{hospitalLocation}")
	public List<Hospital> getHospitalByHospitalLocation(@PathVariable String hospitalLocation);
}

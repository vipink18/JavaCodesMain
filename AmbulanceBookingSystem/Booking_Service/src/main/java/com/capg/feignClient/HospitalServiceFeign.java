package com.capg.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.entity.Hospital;

@FeignClient(name = "HOSPITAL-SERVICE",url = "localhost:1998/api/v1/hospital")
public interface HospitalServiceFeign {

	@GetMapping("/getHospitalById/{hospitalId}")
	public Hospital getHospitalById(@PathVariable String hospitalId);
	
	
}

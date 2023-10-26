package com.hr.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hr.errorDecoder.CustomErrorDecoder;
import com.hr.exceptions.HRException;
import com.hr.model.LocationModel;


@FeignClient(url = "http://localhost:9003/location",name = "locationClient", configuration = CustomErrorDecoder.class)
public interface LocationClient {
	
	@PostMapping("/addLocation")
	public LocationModel addLocation(@RequestBody LocationModel d);
	
	@GetMapping("/getLocationById/{id}")
	public LocationModel getLocationById(@PathVariable int id) throws HRException;
		
	@GetMapping("/getAllLocation")
	public List<LocationModel> getAllLocations();

}

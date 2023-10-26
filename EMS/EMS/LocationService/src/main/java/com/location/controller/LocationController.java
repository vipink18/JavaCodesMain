package com.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location.exceptions.LocationException;
import com.location.model.Location;
import com.location.service.LocationServiceImpl;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	LocationServiceImpl ds;
	
	@PostMapping("/addLocation")
	public ResponseEntity<Location> addLocation(@RequestBody Location d){
		return new ResponseEntity<Location>(ds.addLocation(d), HttpStatus.OK);
	}
	
	@GetMapping("/getLocationById/{id}")
	public ResponseEntity<Location> getLocationById(@PathVariable int id) throws LocationException{
		System.out.println("controller");
		return new ResponseEntity<Location>(ds.getLocationById(id),HttpStatus.OK);
		
	}
	@GetMapping("/getAllLocation")
	public ResponseEntity<List<Location>> getAllLocations(){
		return new ResponseEntity<List<Location>>(ds.getAllLocations(),HttpStatus.OK);
	}
	
	
}

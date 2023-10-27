package com.capg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Hospital;
import com.capg.externalServices.HospitalBookingDetails;
import com.capg.service.HospitalService;
import com.capg.util.HospitalLogin;

@RestController
@RequestMapping("/api/v1/hospital")
@CrossOrigin(origins = "http://localhost:4200")
public class HospitalController {
	private static final Logger log = LoggerFactory.getLogger(HospitalController.class);

	
	@Autowired
	public HospitalService hospitalService;

	// register a new hospital
	@PostMapping("/addNewHospital")
	public ResponseEntity<Hospital> registerHospital(@RequestBody Hospital hospital) {
		log.info("Request received to register a new hospital");
		return new ResponseEntity<Hospital>(hospitalService.addHospital(hospital), HttpStatus.OK);
	}

	// fetch all hospitals
	@GetMapping("/getAllHospitals")
	public ResponseEntity<List<Hospital>> getAllHospitalInfo() {
		 log.info("Request received to fetch all hospitals");
		List<Hospital> fetcHospitals = hospitalService.getAllHospitalInfo();
		return new ResponseEntity<List<Hospital>>(fetcHospitals, HttpStatus.OK);
	}

	// delete hospital
	@DeleteMapping("/deleteHospital/{hospitalId}")
	public void deleteHospital(@PathVariable String hospitalId) {
		log.info("Request received to delete hospital by id: {}", hospitalId);
		hospitalService.deleteHospitalById(hospitalId);
	}

	// get all hospital locations
	@GetMapping("/getAllHospitalLocations")
	public ResponseEntity<List<String>> getAllHospitalLocations() {
		 log.info("Request received to fetch all hospital locations");
		return new ResponseEntity<List<String>>(hospitalService.getAllHospitalLocations(), HttpStatus.OK);
	}

	// fetch hospital by location
	@GetMapping("/getHospitalByHospitalLocation/{userLocation}")
	public ResponseEntity<List<Hospital>> getAllHospitalByHospitalLocation(@PathVariable String userLocation) {
		log.info("Request received to fetch hospitals by location: {}", userLocation);
		List<Hospital> list = hospitalService.getAllHospitalInfo();

		List<Hospital> list1 = new ArrayList<>();
		List<Hospital> list2 = new ArrayList<>();
		list.stream().map(s -> s.getHospitalLocation().equalsIgnoreCase(userLocation) ? list1.add(s) : list2.add(s))
				.collect(Collectors.toList());

		if (list1.isEmpty()) {
			return new ResponseEntity<List<Hospital>>(list2, HttpStatus.OK);
		}
		return new ResponseEntity<List<Hospital>>(list1, HttpStatus.OK);
	}

	// get hospital by id
	@GetMapping("/getHospitalById/{hospitalId}")
	public ResponseEntity<Hospital> getHospitalById(@PathVariable String hospitalId) {
		log.info("Request received to fetch hospital by id: {}", hospitalId);
		return new ResponseEntity<Hospital>(hospitalService.getHospitalById(hospitalId), HttpStatus.OK);
	}

	// for hospital by email id
	@GetMapping("/getHospitalByEmailId/{hospitalEmailId}")
	public ResponseEntity<Optional<Hospital>> getHospitalByEmailId(@PathVariable String hospitalEmailId) {
		log.info("Request received to fetch hospital by email id: {}", hospitalEmailId);
		return new ResponseEntity<Optional<Hospital>>(hospitalService.getHospitalByEmailId(hospitalEmailId),
				HttpStatus.OK);
	}
	
	@GetMapping("/hospitalBookingHistory/{hospitalId}")
	public ResponseEntity<List<HospitalBookingDetails>> hospitalBookingHistory(@PathVariable String hospitalId){
		log.info("Request received to fetch hospital booking history for hospitalId: {}", hospitalId);
		return new ResponseEntity<List<HospitalBookingDetails>>(hospitalService.getAllHospitalBooking(hospitalId),HttpStatus.OK);
	}

	// get all hospital id's
	@GetMapping("/getAllHospitalIds")
	public ResponseEntity<List<String>> getAllHospitalIds() {
		log.info("Request received to fetch all hospital IDs");
		return new ResponseEntity<List<String>>(hospitalService.getAllHospitalIds(), HttpStatus.OK);
	}

	// updating hospital password
	@PutMapping("/changePassword/{hospitalEmailId}/{currentPassword}/{newPassword}")
	public ResponseEntity<Hospital> updatePassword(@PathVariable String hospitalEmailId,
			@PathVariable String currentPassword, @PathVariable String newPassword) {
		log.info("Request received to change password for hospital with email: {}", hospitalEmailId);
		return new ResponseEntity<Hospital>(
				hospitalService.changePassword(hospitalEmailId, currentPassword, newPassword), HttpStatus.OK);
	}

	@PostMapping("/hospitalLogin")
	public ResponseEntity<Hospital> hospitalLogin(@RequestBody HospitalLogin hospitalLogin) {
		log.info("Request received for hospital login with email: {}", hospitalLogin.getEmailId());
		return new ResponseEntity<Hospital>(hospitalService.hospitalLogin(hospitalLogin), HttpStatus.OK);
	}
	@PutMapping("/updateHospital/{hospitalId}")
    public ResponseEntity<Hospital> updateHospital(@PathVariable String hospitalId, @RequestBody Map<String, String> update){
		Hospital fetchHospital = hospitalService.updateHospitalById(hospitalId, update);
        return new ResponseEntity<Hospital>(fetchHospital, HttpStatus.OK);
    }

}
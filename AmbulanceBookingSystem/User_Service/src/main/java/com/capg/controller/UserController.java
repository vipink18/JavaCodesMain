package com.capg.controller;

import java.util.List;
import java.util.Optional;

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

import com.capg.entity.User;
import com.capg.externalServices.UserBookingDetails;
import com.capg.feignClient.AmbulanceServiceFeign;
import com.capg.feignClient.HospitalServiceFeign;
import com.capg.service.UserService;
import com.capg.util.Ambulance;
import com.capg.util.Booking;
import com.capg.util.Hospital;
import com.capg.util.UserLogin;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private HospitalServiceFeign hospitalServiceFeign;

	@Autowired
	private AmbulanceServiceFeign ambulanceServiceFeign;

	// for getting user by id
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable String userId) {
		log.info("Request received to get user by id: {}", userId);
		return new ResponseEntity<Optional<User>>(userService.getUserById(userId), HttpStatus.OK);
	}

	// for getting user by email id
	@GetMapping("/getUserByEmailId/{userEmailId}")
	public ResponseEntity<Optional<User>> getUserByEmailId(@PathVariable String userEmailId) {
		log.info("Request received to get user by emailId: {}", userEmailId);
		return new ResponseEntity<Optional<User>>(userService.getUserByEmailId(userEmailId), HttpStatus.OK);
	}

	// for showing all users
	@GetMapping("/viewAllUser")
	public ResponseEntity<List<User>> viewAllUser() {
		log.info("Request received to view all users");
		return new ResponseEntity<>(userService.viewAllUser(), HttpStatus.OK);
	}

	// for creating user
	@PostMapping("/addUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		log.info("Request received to create user");
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}

	// for deleting the user
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable String userId) {
		log.info("Request received to delete user by id: {}", userId);
		userService.deleteUser(userId);
	}

	// updating the users details
	@PutMapping("updateUser/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId,@RequestBody User user) {
		log.info("Request received to update user by id: {}", userId);
		return new ResponseEntity<User>(userService.updateUser(userId, user), HttpStatus.OK);
	}

	// updating user password
	@PutMapping("/changePassword/{userEmailId}/{currentPassword}/{newPassword}")
	public ResponseEntity<User> updatePassword(@PathVariable String userEmailId, @PathVariable String currentPassword,
			@PathVariable String newPassword) {
		log.info("Request received to update password for user with emailId: {}", userEmailId);
		return new ResponseEntity<User>(userService.changePassword(userEmailId, currentPassword, newPassword),
				HttpStatus.OK);
	}

	// book ambulance
	@PostMapping("/booking/{userId}/{ambulanceId}/{hospitalId}")
	public ResponseEntity<Booking> bookAmbulance(@PathVariable String userId, @PathVariable String hospitalId,
			@PathVariable String ambulanceId) {
		log.info("Request received to book ambulance. userId: {}, hospitalId: {}, ambulanceId: {}", userId, hospitalId,
				ambulanceId);
//		if (userId.equals(null) || hospitalId.equals(null) || ambulanceId.equals(null)) {
//			throw new IdNotFoundException("Id not found!");
//		}
//		Booking booking = new Booking(userId, hospitalId, ambulanceId);
		return new ResponseEntity<Booking>(userService.bookAmbulance(userId, hospitalId, ambulanceId),
				HttpStatus.CREATED);
	}

	// view hospitals by location
	@GetMapping("/getHospitalByHospitalLocation/{hospitalLocation}")
	public ResponseEntity<List<Hospital>> viewAllHospitalsByLocation(@PathVariable String hospitalLocation) {
		log.info("Request received to view hospitals by location: {}", hospitalLocation);
		return new ResponseEntity<List<Hospital>>(hospitalServiceFeign.getHospitalByHospitalLocation(hospitalLocation),
				HttpStatus.OK);
	}

	// view ambulance by location
	@GetMapping(value = "/getAmbulancesByLocation/{ambulanceLocation}")
	public ResponseEntity<List<Ambulance>> viewAllAmbulancesByLocation(@PathVariable String ambulanceLocation) {
		log.info("Request received to view ambulances by location: {}", ambulanceLocation);
		return new ResponseEntity<List<Ambulance>>(ambulanceServiceFeign.getAllAmbulanceByLocation(ambulanceLocation),
				HttpStatus.OK);
	}

	// view previous hospital bookings
	@GetMapping("/userBookingHistory/{userId}")
	public ResponseEntity<List<UserBookingDetails>> userBookingHistory(@PathVariable String userId) {
		log.info("Request received to view previous bookings for userId: {}", userId);
		return new ResponseEntity<List<UserBookingDetails>>(userService.userBookingHistory(userId), HttpStatus.OK);
	}

	// user login api
	@PostMapping("/userLogin")
	public ResponseEntity<User> userLogin(@RequestBody UserLogin userLogin) {
		log.info("Request received for user login with email: {}", userLogin.getEmailId());
		return new ResponseEntity<User>(userService.userLogin(userLogin), HttpStatus.OK);
	}
}
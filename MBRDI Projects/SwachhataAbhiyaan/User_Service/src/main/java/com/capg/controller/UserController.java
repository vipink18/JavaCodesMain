package com.capg.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entities.Complaint;
import com.capg.entities.User;
import com.capg.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable UUID userId){
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.FOUND);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser() {
		return new ResponseEntity<User>(userService.updateUser(),HttpStatus.OK);
		
	}
	//need to write the boolean and logic for existing check
	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(UUID userId) {
		
		boolean userDeleted = true;
	    
	    if (userDeleted) {
	        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
	    }
	    }
		
	@PostMapping("/addComplaint")
	public ResponseEntity<User> addComplaint(@RequestBody User user) {
		return new ResponseEntity<User>(userService.addComplaint(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/searchAreaBy/{area}")
	public ResponseEntity<List<User>> searchAreaBy(@PathVariable String area){
		return new ResponseEntity<List<User>>(userService.searchAreaBy(area),HttpStatus.FOUND);
	}
	
	@GetMapping("/showAllComplaint")
	public ResponseEntity<List<Complaint>> showAllComplaint(){
		return new ResponseEntity<List<Complaint>>(userService.showAllComplaint(),HttpStatus.FOUND);
	}
	

}

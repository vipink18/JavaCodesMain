/*@Author Shuvam Jyoti Saha

This is Controller layer for admin module 
In this class client request is mapped  to the method and sends back the response to the client 

In this controller the add admin and admin login request is handled

*/


package com.sastabasta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sastabasta.entities.Admin;
import com.sastabasta.exceptions.EmailOrPasswordException;
import com.sastabasta.service.AdminService;

@RequestMapping("admin")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.addAdmin(admin),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Admin> checkLogin(@RequestBody Admin admin) throws EmailOrPasswordException {
		return new ResponseEntity<Admin>(adminService.findByEmailAndPassword(admin.getEmail(),admin.getPassword()), HttpStatus.OK);
	}

}

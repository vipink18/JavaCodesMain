package com.emsjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsjwt.clients.EmployeeClient;
import com.emsjwt.model.EmployeeModel;

@RestController
@RequestMapping("/user")
@EnableFeignClients(basePackages = "com.emsjwt.clients")
public class UserController {
	@Autowired
	EmployeeClient employeeClient;
	
	@GetMapping("/viewByEmpId/{id}")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable int id){
		EmployeeModel employeeModel = employeeClient.getEmployeeById(id);
		return new ResponseEntity<EmployeeModel>(employeeModel,HttpStatus.OK);
	}

}

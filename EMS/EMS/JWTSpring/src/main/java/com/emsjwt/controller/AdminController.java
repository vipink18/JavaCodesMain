package com.emsjwt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsjwt.clients.HrClient;
import com.emsjwt.model.EmployeeModel;
import com.emsjwt.model.UserDto;



@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
@EnableFeignClients(basePackages = "com.emsjwt.clients")
public class AdminController {
	@Autowired
	HrClient hrClient; 
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<UserDto>> getAllEmployees() throws SecurityException{
		List<UserDto> employeeModels = hrClient.getAllEmployees();
		
		
 		return new ResponseEntity<List<UserDto>>(employeeModels,HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<UserDto> getEmployeeById(@PathVariable int id ) throws SecurityException{
		UserDto userDto = hrClient.getEmployeeById(id);
		
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	@PostMapping("/addEmployee")
	public ResponseEntity<UserDto> addEmployee(@RequestBody EmployeeModel emp) throws SecurityException{
		UserDto userDto =hrClient.addEmployee(emp);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
	}
	@GetMapping("/getEmployeesByDepartmentId/{id}")
	public ResponseEntity<List<UserDto>> getEmployeesByDepartmentId(@PathVariable int id) throws SecurityException{
		List<UserDto> userDtos = hrClient.getEmployeesByDepartmentId(id);
		return new ResponseEntity<List<UserDto>>(userDtos,HttpStatus.OK );
	}
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) throws SecurityException{
		return new ResponseEntity<String>(hrClient.deleteEmployeeById(id),HttpStatus.OK);
	}

}

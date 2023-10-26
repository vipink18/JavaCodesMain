package com.employee.controller;

import java.util.List;

//import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exceptions.EmployeeException;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService e;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		return new ResponseEntity<Employee>( e.addEmployee(emp),HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) throws EmployeeException{
		return new ResponseEntity<Employee>(e.getEmployeeById(id), HttpStatus.OK);
		
	}
	@GetMapping("/getEmployeeByName/{name}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) throws EmployeeException{
		return new ResponseEntity<Employee>(e.findByName(name), HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable int id) throws EmployeeException{
		return new ResponseEntity<Employee>(e.deleteEmployee(id), HttpStatus.OK);
		
	}
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(e.getAllEmployees(),HttpStatus.OK);
	}
	
				
	
	
	
}

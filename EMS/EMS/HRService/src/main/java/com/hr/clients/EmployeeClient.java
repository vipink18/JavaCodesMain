package com.hr.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.hr.errorDecoder.CustomErrorDecoder;
import com.hr.exceptions.HRException;
import com.hr.model.EmployeeModel;


@FeignClient(url = "http://localhost:9001/employee",name = "employeeClient", configuration = CustomErrorDecoder.class)
public interface EmployeeClient {
	
	@PostMapping("/addEmployee")
	public EmployeeModel addEmployee(@RequestBody EmployeeModel emp);
	
	@GetMapping("/getEmployeeById/{id}")
	public EmployeeModel getEmployeeById(@PathVariable int id) throws HRException;
	@DeleteMapping("/deleteEmployeeById/{id}")
	public EmployeeModel deleteEmployeeById(@PathVariable int id) throws HRException;
	@GetMapping("/getAllEmployees")
	public List<EmployeeModel> getAllEmployees();

}

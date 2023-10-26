package com.hr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hr.clients.DepartmentClient;
import com.hr.clients.EmployeeClient;
import com.hr.clients.LocationClient;
import com.hr.dto.UserDto;
import com.hr.exceptions.HRException;
import com.hr.model.DepartmentModel;
import com.hr.model.EmployeeModel;
import com.hr.model.LocationModel;

@RestController
@RequestMapping("/Hr")
@EnableFeignClients(basePackages = "com.hr.clients")
public class HRController {
	@Autowired
	DepartmentClient departmentClient;
	@Autowired
	EmployeeClient employeeClient;
	@Autowired
	LocationClient locationClient;
	
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<UserDto>> getAllEmployees() throws HRException{
		List<EmployeeModel> employeeModels = employeeClient.getAllEmployees();
		List<UserDto> userDtos = new ArrayList<>();
		for(EmployeeModel employeeModel: employeeModels) {
			DepartmentModel departmentModel = departmentClient.getDepartmentEntityById(employeeModel.getDepartmentId());
			LocationModel locationModel = locationClient.getLocationById(departmentModel.getLocationId());
			UserDto userDto = new UserDto
					(
							employeeModel.getEid(),employeeModel.getName(),
							departmentModel.getDepartmentId(),departmentModel.getDepartmentName(),
							locationModel.getLocationId(),locationModel.getLocationName()
							
							);
			userDtos.add(userDto);
			
		}
		
 		return new ResponseEntity<List<UserDto>>(userDtos,HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<UserDto> getEmployeeById(@PathVariable int id ) throws HRException{
		EmployeeModel employeeModel = employeeClient.getEmployeeById(id);
		DepartmentModel departmentModel = departmentClient.getDepartmentEntityById(employeeModel.getDepartmentId());
		LocationModel locationModel = locationClient.getLocationById(departmentModel.getLocationId());
		UserDto userDto = new UserDto
				(
						employeeModel.getEid(),employeeModel.getName(),
						departmentModel.getDepartmentId(),departmentModel.getDepartmentName(),
						locationModel.getLocationId(),locationModel.getLocationName()
						
						);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	@PostMapping("/addEmployee")
	public ResponseEntity<UserDto> addEmployee(@RequestBody EmployeeModel emp) throws HRException{
		EmployeeModel employeeModel = employeeClient.addEmployee(emp);
		DepartmentModel departmentModel = departmentClient.getDepartmentEntityById(emp.getDepartmentId());
		LocationModel locationModel = locationClient.getLocationById(departmentModel.getLocationId());
		UserDto userDto = new UserDto
				(
						employeeModel.getEid(),employeeModel.getName(),
						departmentModel.getDepartmentId(),departmentModel.getDepartmentName(),
						locationModel.getLocationId(),locationModel.getLocationName()
						
						);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
	}
	@GetMapping("/getEmployeesByDepartmentId/{id}")
	public ResponseEntity<List<UserDto>> getEmployeesByDepartmentId(@PathVariable int id) throws HRException{
		List<EmployeeModel> employeeModels = employeeClient.getAllEmployees();
		DepartmentModel departmentModel = departmentClient.getDepartmentEntityById(id);
		LocationModel locationModel = locationClient.getLocationById(departmentModel.getLocationId());
		List<UserDto> userDtos = new ArrayList<>();
		for(EmployeeModel employee : employeeModels) {
			if(employee.getDepartmentId() == id) {
				UserDto userDto = new UserDto
						(
								employee.getEid(),employee.getName(),
								
								departmentModel.getDepartmentId(),departmentModel.getDepartmentName(),
								locationModel.getLocationId(),locationModel.getLocationName()
								
								);
				employeeModels.add(employee);
			}
			
		}
		return new ResponseEntity<List<UserDto>>(userDtos,HttpStatus.OK );
	}
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) throws HRException{
		EmployeeModel employeeModel=  employeeClient.deleteEmployeeById(id);
		if(employeeModel== null) {
			return new ResponseEntity<String>("Delete Failed", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Delete Sucess", HttpStatus.OK);
	}

}

package com.hr.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hr.errorDecoder.CustomErrorDecoder;
import com.hr.exceptions.HRException;
import com.hr.model.DepartmentModel;


@FeignClient(url = "http://localhost:9002/department",name = "departmentClient",  configuration = CustomErrorDecoder.class)
public interface DepartmentClient {
	
	@PostMapping("/addDepartment")
	public  DepartmentModel addDepartment(@RequestBody DepartmentModel d);
	@GetMapping("/getDepartmentById/{id}")
	public DepartmentModel getDepartmentEntityById(@PathVariable int id) throws HRException;
	@GetMapping("/getAllDepartments")
	public List<DepartmentModel> getAllDepartments();

}

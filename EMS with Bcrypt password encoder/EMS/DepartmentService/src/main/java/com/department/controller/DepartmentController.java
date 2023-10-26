package com.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.exceptions.DepartmentException;
import com.department.model.Department;
import com.department.service.DepartmentServiceImpl;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentServiceImpl ds;
	
	@PostMapping("/addDepartment")
	public ResponseEntity<Department> addDepartment(@RequestBody Department d){
		return new ResponseEntity<Department>(ds.addDepartment(d), HttpStatus.OK);
	}
	
	@GetMapping("/getDepartmentById/{id}")
	public ResponseEntity<Department> getDepartmEntityById(@PathVariable int id) throws DepartmentException{
		return new ResponseEntity<Department>(ds.getDepartmentById(id),HttpStatus.OK);
		
	}
	@GetMapping("/getAllDepartments")
	public ResponseEntity<List<Department>> getAllDepartments(){
		return new ResponseEntity<List<Department>>(ds.getAllDepartments(),HttpStatus.OK);
	}
	
}

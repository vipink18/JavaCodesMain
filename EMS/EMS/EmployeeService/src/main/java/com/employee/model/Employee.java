package com.employee.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Employees")
public class Employee {
	
	@MongoId
	private int eid;
	private String name;
	private String password;	
	private String gender;
	private String role;
	private int age;
	private double salary;
	private int departmentId;

}

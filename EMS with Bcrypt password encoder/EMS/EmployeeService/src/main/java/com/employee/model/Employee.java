package com.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection = "Employees")
@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	private int eid;
	private String name;
	private String password;	
	private String gender;
	private String role;
	private int age;
	private double salary;
	private int departmentId;

}

package com.employee.service;

import java.util.List;

import com.employee.exceptions.EmployeeException;
import com.employee.model.Employee;

public interface EmployeeServiceInterface {
	
	Employee addEmployee(Employee emp);
	Employee getEmployeeById(int id) throws EmployeeException;
	List<Employee> getAllEmployees();
	Employee findByName(String name) throws EmployeeException;
	Employee deleteEmployee(int id) throws EmployeeException;
//	Employee updateEmployee(int id, Employee emp);
//	Employee deleteEmployee(int id);

}

package com.department.service;

import java.util.List;

import com.department.exceptions.DepartmentException;
import com.department.model.Department;

public interface DepartmentService {

	Department addDepartment(Department d);
	Department getDepartmentById(int id) throws DepartmentException;
	List<Department> getAllDepartments();
}

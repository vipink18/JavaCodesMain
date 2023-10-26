package com.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.exceptions.DepartmentException;
import com.department.model.Department;
import com.department.repository.DepartmentRepository;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository dr;

	@Override
	public Department addDepartment(Department d) {
		// TODO Auto-generated method stub
		return dr.save(d);
	}

	@Override
	public Department getDepartmentById(int id) throws DepartmentException {
		// TODO Auto-generated method stub
		Department d = null;
		d = dr.findById(id).get();
		if(d==null) {
			throw new DepartmentException("soorryyyy");
		}
		return d;
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return dr.findAll();
	}
	
	

}

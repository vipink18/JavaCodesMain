package com.department.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.department.model.Department;

@Repository
//public interface DepartmentRepository extends MongoRepository<Department, Integer> {
//
//}
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
}
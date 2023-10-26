package com.department.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection="Departments")
@Entity
@Table(name = "Department")
public class Department {

	@Id
	private int departmentId;
	private String departmentName;
	private int locationId;
}

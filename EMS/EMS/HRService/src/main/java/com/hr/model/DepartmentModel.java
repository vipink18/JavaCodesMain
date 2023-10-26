package com.hr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModel {

	private int departmentId;
	private String departmentName;
	private int locationId;
}

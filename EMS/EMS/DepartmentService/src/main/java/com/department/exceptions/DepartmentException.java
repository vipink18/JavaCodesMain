package com.department.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentException extends Exception {
	
	public DepartmentException(String msg) {
		super(msg);
	}

}

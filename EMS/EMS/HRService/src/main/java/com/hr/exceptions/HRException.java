package com.hr.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HRException extends Exception {
	public HRException(String msg) {
		super(msg);
	}
}

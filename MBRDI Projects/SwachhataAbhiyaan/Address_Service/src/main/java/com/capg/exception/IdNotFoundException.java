package com.capg.exception;

import java.util.UUID;

public class IdNotFoundException extends RuntimeException {

	public IdNotFoundException(String msg){
		super(msg);
	}
}

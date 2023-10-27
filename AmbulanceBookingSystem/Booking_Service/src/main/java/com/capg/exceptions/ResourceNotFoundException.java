package com.capg.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		super("Resource not found on server");
	}
	ResourceNotFoundException(String msg){
		super(msg);
	}
	

}

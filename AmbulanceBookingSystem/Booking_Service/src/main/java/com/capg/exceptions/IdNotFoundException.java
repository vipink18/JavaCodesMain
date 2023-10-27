package com.capg.exceptions;

public class IdNotFoundException extends RuntimeException {

	public IdNotFoundException(){
		super("Id not found for the resource ");
	}
	
	public IdNotFoundException(String msg){
		super(msg);
	}
	
}

package com.capg.exception;

public class InvalidPasswordException extends RuntimeException{
	public InvalidPasswordException(){
		super("Invalid Password.");
	}
	
	public InvalidPasswordException(String msg){
		super(msg);
	}

}

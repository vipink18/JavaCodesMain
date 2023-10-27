package com.capg.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorDetails> idNotFoundException(IdNotFoundException exception){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorMessage(exception.getMessage());
		errorDetails.setErrorStatus(HttpStatus.NOT_FOUND.toString());
		errorDetails.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ErrorDetails> invalidPasswordException(InvalidPasswordException exception){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorMessage(exception.getMessage());
		errorDetails.setErrorStatus(HttpStatus.NOT_FOUND.toString());
		errorDetails.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
}

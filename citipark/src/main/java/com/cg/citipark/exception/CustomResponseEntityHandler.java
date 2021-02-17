package com.cg.citipark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
@RestController
public class CustomResponseEntityHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<Object> handleDuplicateUserException(DuplicateUserException ex, WebRequest request){
		DuplicateUserExceptionResponse duplicateUserExceptionResponse =  new DuplicateUserExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(duplicateUserExceptionResponse,HttpStatus.BAD_REQUEST);
	}	
	
	@ExceptionHandler
	public ResponseEntity<Object> handleNoSuchUserFoundException(NoSuchUserFoundException ex, WebRequest request){
		NoSuchUserFoundExceptionResponse noSuchUserFoundExceptionResponse =  new NoSuchUserFoundExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(noSuchUserFoundExceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleInvalidLoginCredentialsException(InvalidLoginCredentialsException ex, WebRequest request){
		InvalidLoginCredentialsExceptionResponse invalidLoginCredentialsExceptionResponse =  new InvalidLoginCredentialsExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(invalidLoginCredentialsExceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
}

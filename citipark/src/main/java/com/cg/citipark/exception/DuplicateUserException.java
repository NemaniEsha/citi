package com.cg.citipark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateUserException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateUserException() {
		super();
	}
	
	public DuplicateUserException(String errMsg) {
		super(errMsg);
	}
}
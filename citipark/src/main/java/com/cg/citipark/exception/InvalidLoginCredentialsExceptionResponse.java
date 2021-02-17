package com.cg.citipark.exception;

public class InvalidLoginCredentialsExceptionResponse {
	private String userName;

	public InvalidLoginCredentialsExceptionResponse(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}

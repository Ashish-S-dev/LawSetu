package com.TechCoder.LawSetu.helper;

import org.springframework.http.HttpStatus;

public class CustomResponse {
	
	private String message;
	
	private HttpStatus httpStatus;
	
	private String userEmail ;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public CustomResponse() {};

	public CustomResponse(String message, HttpStatus httpStatus, String userEmail) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.userEmail = userEmail;
	}
	
	
}
package com.TechCoder.LawSetu.helper;

public class LoginData {
	
	private String userEmail;
	
	private String userPassword;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public LoginData() {};
	
	public LoginData(String userEmail, String userPassword) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "LoginData [userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}
	
	
	
	
}

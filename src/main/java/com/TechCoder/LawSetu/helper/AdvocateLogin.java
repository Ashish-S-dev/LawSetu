package com.TechCoder.LawSetu.helper;

public class AdvocateLogin {
	
	private String userEmail;
	
	private String userPassword;

	private String barCouncilid;
	
	public String getBarCouncilid() {
		return barCouncilid;
	}

	public void setBarCouncilid(String barCouncilid) {
		this.barCouncilid = barCouncilid;
	}

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

	public AdvocateLogin() {}

	public AdvocateLogin(String userEmail, String userPassword, String barCouncilid) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.barCouncilid = barCouncilid;
	};
	
	

	
}

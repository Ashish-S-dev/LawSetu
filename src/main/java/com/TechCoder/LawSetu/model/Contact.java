package com.TechCoder.LawSetu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contact-us")
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_message")
	private String userMessage;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	
	public Contact() {};
	
	public Contact(String userName, String userEmail, String userMessage) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMessage = userMessage;
	}

	@Override
	public String toString() {
		return "Contact [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userMessage="
				+ userMessage + "]";
	}
	
	
		
}

package com.TechCoder.LawSetu.service;

import com.TechCoder.LawSetu.model.Contact;

public interface EmailService {

	public void contactUsMail(Contact contactObj);

	public void accountCreated(String userEmail);

	public void sendOtpEmail(String userEmail, Integer otpValue);

	public void accountActivated(String userEmail);
	
}

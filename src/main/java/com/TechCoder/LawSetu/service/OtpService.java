package com.TechCoder.LawSetu.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechCoder.LawSetu.dao.OtpDao;
import com.TechCoder.LawSetu.model.OtpTbl;

import jakarta.transaction.Transactional;

@Service
public class OtpService {
	
	@Autowired
	private OtpDao otpDao;
	@Autowired 
	private EmailServiceImpl emailService;
	// Delete otp using user email
	
	@Transactional
	public void deleteOtp(String userEmail) {
		
		OtpTbl otpObj = findByUserEmail(userEmail);
		
		if(otpObj.getOtpId() != null) {
			
			otpDao.deleteByUserEmail(userEmail);
			
		}
		
		
	}
	
	// Searching in OTP table by email
	public OtpTbl findByUserEmail(String userEmail) {
		return otpDao.findByUserEmail(userEmail).orElse(new OtpTbl());
	}
	
//	OTP Generation 
	@Transactional
	public OtpTbl generateOtp(String userEmail) {
		
		// Removing the Existing Otp from database
		
		deleteOtp(userEmail);
		
	    // Regenerating the OTP For the user	
		OtpTbl otpTbl = new OtpTbl();
		Integer otpVal = (int)(Math.random() * 900000) + 100000;
		otpTbl.setOtp(otpVal);
		otpTbl.setExpiryTime(LocalDateTime.now().plusMinutes(2));
		otpTbl.setUserEmail(userEmail);
		emailService.sendOtpEmail(userEmail, otpVal);
		return otpDao.save(otpTbl);
		
	}
	
	// Find all OTP Data
	public Iterable<OtpTbl> findAll(){
		
		return otpDao.findAll();
		
	}
	
}

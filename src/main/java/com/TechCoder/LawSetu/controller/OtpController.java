package com.TechCoder.LawSetu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechCoder.LawSetu.helper.CustomResponse;
import com.TechCoder.LawSetu.model.OtpTbl;
import com.TechCoder.LawSetu.model.User;
import com.TechCoder.LawSetu.service.OtpService;
import com.TechCoder.LawSetu.service.UserService;



@RestController
@RequestMapping(value="/lawsetu")
public class OtpController {
	
	@Autowired
	private OtpService otpService;
	
	@Autowired
	private UserService userService;
	
	// Send OTP
	@GetMapping(value="/send-otp/{userEmail}")
	public ResponseEntity<CustomResponse> generateOtp(@PathVariable("userEmail") String userEmail) {
			
		// Check Wether user present or not
		User userObj = userService.findByUserEmail(userEmail);
		
		CustomResponse customResponse = new CustomResponse();
		
		if(userObj.getUserId() != null) {
			
			OtpTbl otpTbl = otpService.generateOtp(userEmail);
			
			if(otpTbl.getOtpId() != null) {
				customResponse.setMessage("OTP Send Successfully");
			}else {
				customResponse.setMessage("Resend OTP");
			}
			
		}else {
			customResponse.setMessage("Email not exist");
		}
		
		customResponse.setUserEmail(userEmail);
		customResponse.setHttpStatus(HttpStatus.OK);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
		
		
	}
	
	@GetMapping(value="/find-otp-user-email/{userEmail}")
	public OtpTbl findUser(@PathVariable("userEmail") String userEmail) {
		return otpService.findByUserEmail(userEmail);
	}
	
	@GetMapping(value="/find-all-otp")
	public Iterable<OtpTbl> findAll(){
		
		return otpService.findAll();
		
	}	
	
	@GetMapping(value="/delete-otp/{userEmail}")
	public void deleteOtp(@PathVariable("userEmail") String userEmail){
		
		otpService.deleteOtp(userEmail);
		
	}
}

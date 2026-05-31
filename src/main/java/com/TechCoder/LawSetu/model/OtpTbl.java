package com.TechCoder.LawSetu.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="otp_tbl")
public class OtpTbl {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="otp_id")
	private Integer otpId;
	
//	@Column(unique = true, nullable = false)
	private String userEmail;
	
	@Column(name="otp")
	private Integer otp;
	
	@Column(name="expiry_time")
	private LocalDateTime expiryTime;

	public Integer getOtpId() {
		return otpId;
	}

	public void setOtpId(Integer otpId) {
		this.otpId = otpId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(LocalDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}

	public OtpTbl() {
		
	}
	
	public OtpTbl(String userEmail, Integer otp, LocalDateTime expiryTime) {
		super();
		this.userEmail = userEmail;
		this.otp = otp;
		this.expiryTime = expiryTime;
	}

	@Override
	public String toString() {
		return "OtpTbl [otpId=" + otpId + ", userEmail=" + userEmail + ", otp=" + otp + ", expiryTime=" + expiryTime
				+ "]";
	}
	
	
	
}


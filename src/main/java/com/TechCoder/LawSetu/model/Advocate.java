package com.TechCoder.LawSetu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="advocate_tbl")
public class Advocate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advocateId;

    private String userEmail; 

    @Column(unique = true, nullable = false)
    private String barCouncilNumber;

    private String specialization;

    private int experience;

    private boolean isVerified = false;

	public Long getAdvocateId() {
		return advocateId;
	}

	public void setAdvocateId(Long advocateId) {
		this.advocateId = advocateId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getBarCouncilNumber() {
		return barCouncilNumber;
	}

	public void setBarCouncilNumber(String barCouncilNumber) {
		this.barCouncilNumber = barCouncilNumber;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
    public Advocate() {
    	
    }

	public Advocate(String userEmail, String barCouncilNumber, String specialization, int experience,
			boolean isVerified) {
		super();
		this.userEmail = userEmail;
		this.barCouncilNumber = barCouncilNumber;
		this.specialization = specialization;
		this.experience = experience;
		this.isVerified = isVerified;
	}

	@Override
	public String toString() {
		return "Advocate [advocateId=" + advocateId + ", userEmail=" + userEmail + ", barCouncilNumber="
				+ barCouncilNumber + ", specialization=" + specialization + ", experience=" + experience
				+ ", isVerified=" + isVerified + "]";
	}
	
    
}

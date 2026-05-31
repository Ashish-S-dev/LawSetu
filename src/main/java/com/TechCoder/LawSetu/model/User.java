package com.TechCoder.LawSetu.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    @Column(unique = true, nullable = false)
    private String userEmail;
    
    private String userMobileNo;

    private String userPassword;

    private String userCity;

    private Integer userRole;   // ROLE_USER, ROLE_ADVOCATE, ROLE_ADMIN

    private boolean isActive = false;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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

	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User() {};
	
	public User(String userName, String userEmail, String userMobileNo, String userPassword, String userCity,
			Integer userRole, boolean isActive) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobileNo = userMobileNo;
		this.userPassword = userPassword;
		this.userCity = userCity;
		this.userRole = userRole;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userMobileNo="
				+ userMobileNo + ", userPassword=" + userPassword + ", userCity=" + userCity + ", userDesiganation="
				+ userRole + ", isActive=" + isActive + "]";
	}
    
    
	
	
    
}

package com.TechCoder.LawSetu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_role")
public class Roles {
	
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer roleId;
	
	@Column(name="user_role")
	private String userRole;

	public Integer getUserId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public Roles() {
		
	}

	public Roles(String userRole) {
		super();
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "Role [userId=" + roleId + ", userName=" + userRole + "]";
	}
	
	
}


package com.TechCoder.LawSetu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bar_council_id")
public class BarCouncilId {

	@Id
	@Column(name="bar_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="bar_council_id")
	private String barCouncilId;
	
	@Column(name="lawyerEmail")
	private String lawyerEmail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarCouncilId() {
		return barCouncilId;
	}

	public void setBarCouncilId(String barCouncilId) {
		this.barCouncilId = barCouncilId;
	}

	public String getLawyerEmail() {
		return lawyerEmail;
	}

	public void setLawyerEmail(String lawyerEmail) {
		this.lawyerEmail = lawyerEmail;
	}

	public BarCouncilId(String barCouncilId, String lawyerEmail) {
		super();
		this.barCouncilId = barCouncilId;
		this.lawyerEmail = lawyerEmail;
	}
	
	public BarCouncilId() {}
	
}

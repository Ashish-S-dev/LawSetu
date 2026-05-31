package com.TechCoder.LawSetu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="feedback_tbl")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="feedback_id")
	private Integer fdbkId;
	
	@Column(name="feedback_userName")
	private String fdbkUserName;
	
	@Column(name="feedback_message")
	private String fdbkMessage;

	
	public Integer getFdbkId() {
		return fdbkId;
	}

	public void setFdbkId(Integer fdbkId) {
		this.fdbkId = fdbkId;
	}

	public String getFdbkUserName() {
		return fdbkUserName;
	}

	public void setFdbkUserName(String fdbkUserName) {
		this.fdbkUserName = fdbkUserName;
	}

	public String getFdbkMessage() {
		return fdbkMessage;
	}

	public void setFdbkMessage(String fdbkMessage) {
		this.fdbkMessage = fdbkMessage;
	}

	public Feedback() {}
	
	public Feedback(String fdbkUserName, String fdbkMessage) {
		super();
		this.fdbkUserName = fdbkUserName;
		this.fdbkMessage = fdbkMessage;
	}

	@Override
	public String toString() {
		return "Feedback [fdbkId=" + fdbkId + ", fdbkUserName=" + fdbkUserName + ", fdbkMessage=" + fdbkMessage + "]";
	}
	
	
	
}

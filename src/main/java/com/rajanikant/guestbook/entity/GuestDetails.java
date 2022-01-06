package com.rajanikant.guestbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Rajanikant Yadav
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GUEST")
public class GuestDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="GUEST_SEQUENCE")
	@SequenceGenerator(name= "GUEST_SEQUENCE", sequenceName = "GUEST_SEQUENCE_ID", allocationSize = 1)
	@Column(name = "guest_Id")
	Long guestId;
	
	@Column(name = "guest_Name")
    String guestName;
	
	@Column(name = "guest_Age")
    String guestAge;
	
	@Column(name = "Email_Id")
    String emailId;
	
	@Column(name = "feedback")

	String feedback;

	 @JsonProperty(value = "guestId")
	public Long getGuestId() {
		return guestId;
	}

	 @JsonProperty(value = "guestId")
	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}

	 @JsonProperty(value = "guestName")
	public String getGuestName() {
		return guestName;
	}

	 @JsonProperty(value = "guestName")
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	 @JsonProperty(value = "guestrAge")
	public String getGuestAge() {
		return guestAge;
	}
	 @JsonProperty(value = "guestrAge")
	public void setGuestAge(String guestAge) {
		this.guestAge = guestAge;
	}

	 @JsonProperty(value = "emailId")
	public String getEmailId() {
		return emailId;
	}

	 @JsonProperty(value = "emailId")
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	 @JsonProperty(value = "feedback")
	public String getFeedback() {
		return feedback;
	}

	 @JsonProperty(value = "feedback")
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}

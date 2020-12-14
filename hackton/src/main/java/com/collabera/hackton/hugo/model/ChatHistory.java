package com.collabera.hackton.hugo.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="chat_history")
public class ChatHistory {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
    private Long userId;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "usertype")
	private String userType;
	
	@Column(name = "question")
	private String questions;
	
	@Column(name = "answer")
	private String answer;
		
	@Column(name = "submission_date")
	@Temporal(TemporalType.DATE)
	private Date submissionDate;

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}
	
	
}

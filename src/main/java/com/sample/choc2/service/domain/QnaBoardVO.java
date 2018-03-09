package com.sample.choc2.service.domain;

import java.util.Date;

public class QnaBoardVO {
	private int qnaBoardNo;
	private String qnaBoardCategory;
	private String qnaboardContent;
	private String userId;
	private String email;
	private Date regdate;
	public int getQnaBoardNo() {
		return qnaBoardNo;
	}
	public void setQnaBoardNo(int qnaBoardNo) {
		this.qnaBoardNo = qnaBoardNo;
	}
	public String getQnaBoardCategory() {
		return qnaBoardCategory;
	}
	public void setQnaBoardCategory(String qnaBoardCategory) {
		this.qnaBoardCategory = qnaBoardCategory;
	}
	public String getQnaboardContent() {
		return qnaboardContent;
	}
	public void setQnaboardContent(String qnaboardContent) {
		this.qnaboardContent = qnaboardContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "QnaBoardVO [qnaBoardNo=" + qnaBoardNo + ", qnaBoardCategory=" + qnaBoardCategory + ", qnaboardContent="
				+ qnaboardContent + ", userId=" + userId + ", email=" + email + ", regdate=" + regdate + "]";
	}
	
	
}

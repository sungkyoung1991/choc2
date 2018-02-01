package com.sample.choc2.service.domain;

public class User {
	
	///Field
	private String userId; //아이디
	private String password; //비밀번호
	private String nickName; //닉네임 
	private String name;  //이름
	private String email; //이메일
	private String address; //주소
	private int phoneNo; //핸드폰번호
	private String gender; //성별
	private int age; //나이
	private int jumin; //주민
	private String uuid;//기기 고유값
	
	///Constructor
	public User(){
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + "]";
	}
	
	
	
}
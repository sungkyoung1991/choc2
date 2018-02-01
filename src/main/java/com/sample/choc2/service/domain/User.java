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
	private String role; //사용자, 관리자, 슈퍼유
	
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getJumin() {
		return jumin;
	}

	public void setJumin(int jumin) {
		this.jumin = jumin;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", nickName=" + nickName + ", name=" + name
				+ ", email=" + email + ", address=" + address + ", phoneNo=" + phoneNo + ", gender=" + gender + ", age="
				+ age + ", jumin=" + jumin + ", uuid=" + uuid + ", role=" + role + "]";
	}

	
	
}
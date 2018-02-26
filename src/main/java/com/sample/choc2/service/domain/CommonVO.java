package com.sample.choc2.service.domain;

public class CommonVO {
	private int common_no;
	private String role;

	public int getCommon_no() {
		return common_no;
	}
	public void setCommon_no(int common_no) {
		this.common_no = common_no;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "CommonVo [common_no=" + common_no + ", role=" + role + "]";
	}
}

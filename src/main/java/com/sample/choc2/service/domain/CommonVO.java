package com.sample.choc2.service.domain;

public class CommonVO {
	private int commonNo;
	private String role;

	public int getCommonNo() {
		return commonNo;
	}
	public void setCommonNo(int commonNo) {
		this.commonNo = commonNo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "CommonVo [commonNo=" + commonNo + ", role=" + role + "]";
	}
}

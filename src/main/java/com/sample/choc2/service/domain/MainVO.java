package com.sample.choc2.service.domain;

public class MainVO {

	String sampl1;
	int sampl2;

	public MainVO(String sampl1, int sampl2) {
		super();
		this.sampl1 = sampl1;
		this.sampl2 = sampl2;
	}

	public String getSampl1() {
		return sampl1;
	}

	public void setSampl1(String sampl1) {
		this.sampl1 = sampl1;
	}

	public int getSampl2() {
		return sampl2;
	}

	public void setSampl2(int sampl2) {
		this.sampl2 = sampl2;
	}

}

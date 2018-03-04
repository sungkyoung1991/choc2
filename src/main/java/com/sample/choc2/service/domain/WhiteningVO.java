package com.sample.choc2.service.domain;

public class WhiteningVO {
	private int whiteningNo;
	private String ingredient;
	
	public int getWhiteningNo() {
		return whiteningNo;
	}
	public void setWhiteningNo(int whiteningNo) {
		this.whiteningNo = whiteningNo;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	@Override
	public String toString() {
		return "WhiteningVO [whiteningNo=" + whiteningNo + ", ingredient=" + ingredient + "]";
	}
	
}

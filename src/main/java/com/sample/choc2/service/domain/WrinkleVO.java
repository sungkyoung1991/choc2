package com.sample.choc2.service.domain;

public class WrinkleVO {
	private int wrinkleNo;
	private String ingredient;
	public int getWrinkleNo() {
		return wrinkleNo;
	}
	public void setWrinkleNo(int wrinkleNo) {
		this.wrinkleNo = wrinkleNo;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	@Override
	public String toString() {
		return "WrinkleVO [wrinkleNo=" + wrinkleNo + ", ingredient=" + ingredient + "]";
	}
	
}

package com.sample.choc2.service.domain;

public class UvraysVO {
	private int uvNo;
	private String ingredient;
	public int getUvNo() {
		return uvNo;
	}
	public void setUvNo(int uvNo) {
		this.uvNo = uvNo;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	@Override
	public String toString() {
		return "UvraysVO [uvNo=" + uvNo + ", ingredient=" + ingredient + "]";
	}
	
	
	
}

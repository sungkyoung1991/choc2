package com.sample.choc2.service.domain;

public class DryVO {
	private int dryNo;
	private String goodIngredient;
	private String goodDescription;
	private String badIngredient;
	private String badDescription;
	public int getDryNo() {
		return dryNo;
	}
	public void setDryNo(int dryNo) {
		this.dryNo = dryNo;
	}
	public String getGoodIngredient() {
		return goodIngredient;
	}
	public void setGoodIngredient(String goodIngredient) {
		this.goodIngredient = goodIngredient;
	}
	public String getGoodDescription() {
		return goodDescription;
	}
	public void setGoodDescription(String goodDescription) {
		this.goodDescription = goodDescription;
	}
	public String getBadIngredient() {
		return badIngredient;
	}
	public void setBadIngredient(String badIngredient) {
		this.badIngredient = badIngredient;
	}
	public String getBadDescription() {
		return badDescription;
	}
	public void setBadDescription(String badDescription) {
		this.badDescription = badDescription;
	}
	@Override
	public String toString() {
		return "DryVO [dryNo=" + dryNo + ", goodIngredient=" + goodIngredient + ", goodDescription=" + goodDescription
				+ ", badIngredient=" + badIngredient + ", badDescription=" + badDescription + "]";
	}
	
}

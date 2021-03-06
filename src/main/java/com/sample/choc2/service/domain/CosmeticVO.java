package com.sample.choc2.service.domain;

public class CosmeticVO {
	private int cosmeticNo;
	private String brand;
	private String model;
	private String product;
	private String amount;
	private String price;
	private String ingredient;
	private String image;

	public int getCosmeticNo() {
		return cosmeticNo;
	}

	public void setCosmeticNo(int cosmeticNo) {
		this.cosmeticNo = cosmeticNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "CosmeticVO [cosmeticNo=" + cosmeticNo + ", brand=" + brand + ", model=" + model + ", product="
				+ product + ", amount=" + amount + ", price=" + price + ", ingredient=" + ingredient + ", image="
				+ image + "]";
	}

}

package com.sample.choc2.service.domain;

public class Product {

	private int productNo;
	private String productImage;
	private String productModel;

	public Product() {
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productImage=" + productImage + ", productModel=" + productModel
				+ "]";
	}

}
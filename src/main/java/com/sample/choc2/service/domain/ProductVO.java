package com.sample.choc2.service.domain;

public class ProductVO {

	
	int productNo;
	String productModel;
	String productImage;

	public ProductVO() {
		super();
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "ProductVO [productNo=" + productNo + ", productModel=" + productModel + ", productImage=" + productImage
				+ "]";
	}
	
	
	
	

}

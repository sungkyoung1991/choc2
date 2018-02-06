package com.sample.choc2.service.domain;

public class MainVO {

	ProductVO product;

	public MainVO() {
		super();
	}

	public ProductVO getProduct() {
		return product;
	}

	public void setProduct(ProductVO product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "MainVO [product=" + product + "]";
	}

}

package com.sample.choc2.common.domain;

public class CrawlingVO {
	String productName;//상품 이름 
  
	String brand;//브랜드 
    String price;//가격 
    String imagePath; //까격 
    
    String mount; // 용량					
    String skinType;// 피부타입			
    String term;// 사용기간 				
    String method; //사용방법 				
    String manufacturer; //제조사 		
    String origination;// 제조국 		
    String ingredient;// 성분 			
	String functional;// 기능성 화장품 		
	String precautions;// 주의사항		
    @Override
	public String toString() {
		return "CrawlingVO [product=" + productName + ", brand=" + brand + ", price=" + price + ", imagePath=" + imagePath
				+ ", mount=" + mount + ", skinType=" + skinType + ", term=" + term + ", method=" + method
				+ ", manufacturer=" + manufacturer + ", origination=" + origination + ", ingredient=" + ingredient
				+ ", functional=" + functional + ", precautions=" + precautions + "]";
	}
    public String getProductName() {
  		return productName;
  	}

  	public void setProductName(String productName) {
  		this.productName = productName;
  	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getMount() {
		return mount;
	}
	public void setMount(String mount) {
		this.mount = mount;
	}
	public String getSkinType() {
		return skinType;
	}
	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getOrigination() {
		return origination;
	}
	public void setOrigination(String origination) {
		this.origination = origination;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public String getFunctional() {
		return functional;
	}
	public void setFunctional(String functional) {
		this.functional = functional;
	}
	public String getPrecautions() {
		return precautions;
	}
	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}
		
    
}

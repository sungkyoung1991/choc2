package com.sample.choc2.service.domain;

public class ReviewVO {
	private int reviewNo;//리뷰번호
	private String rating;//평점
	private String period; //사용기간
	private String repurchase; //재구매 여부
	private String strength;// 좋았던 점
	private String weakness;//안좋았던 점
	private String tip; //꿀팁
	private String image;//이미지
	private String cosmeticNo; //화장품번호
	
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getRepurchase() {
		return repurchase;
	}
	public void setRepurchase(String repurchase) {
		this.repurchase = repurchase;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getWeakness() {
		return weakness;
	}
	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCosmeticNo() {
		return cosmeticNo;
	}
	public void setCosmeticNo(String cosmeticNo) {
		this.cosmeticNo = cosmeticNo;
	}
	@Override
	public String toString() {
		return "ReviewVO [reviewNo=" + reviewNo + ", rating=" + rating + ", period=" + period + ", repurchase="
				+ repurchase + ", strength=" + strength + ", weakness=" + weakness + ", tip=" + tip + ", image=" + image
				+ ", cosmeticNo=" + cosmeticNo + "]";
	}
	
}

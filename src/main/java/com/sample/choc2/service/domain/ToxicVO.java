package com.sample.choc2.service.domain;

public class ToxicVO {
	private int toxicNo;
	private String toxicKoreanName;
	private String toxicEnglishName;
	private String description;
	
	public ToxicVO(){
	}

	public int getToxicNo() {
		return toxicNo;
	}
	public void setToxicNo(int toxicNo) {
		this.toxicNo = toxicNo;
	}
	public String getToxicKoreanName() {
		return toxicKoreanName;
	}
	public void setToxicKoreanName(String toxicKoreanName) {
		this.toxicKoreanName = toxicKoreanName;
	}
	public String getToxicEnglishName() {
		return toxicEnglishName;
	}
	public void setToxicEnglishName(String toxicEnglishName) {
		this.toxicEnglishName = toxicEnglishName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ToxicVO [toxicNo=" + toxicNo + ", toxicKoreanName=" + toxicKoreanName + ", toxicEnglishName="
				+ toxicEnglishName + ", description=" + description + "]";
	}
	
	
	
}

package com.kubg.domain;

public class CategoryVO {

	private String cateName;
	private String cateCode;
	private String cateCodeRef;
	private String level;
	
	
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getCateCodeRef() {
		return cateCodeRef;
	}
	public void setCateCodeRef(String cateCodeRef) {
		this.cateCodeRef = cateCodeRef;
	}
	@Override
	public String toString() {
		return "CategoryVO [cateName=" + cateName + ", cateCode=" + cateCode + ", cateCodeRef=" + cateCodeRef
				+ ", level=" + level + "]";
	}
	
	
	
}

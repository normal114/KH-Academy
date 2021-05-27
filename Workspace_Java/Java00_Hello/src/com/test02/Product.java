package com.test02;

public abstract class Product {
	
	private int productCode;
	private String productName;
	
	public Product(int productCode, String productName) {
		super();
		this.productCode = productCode;
		this.productName = productName;
	}
	
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Override
	public String toString() {
		return "상품코드 : " + productCode + ", 상품명 : " + productName;
	}
	
	public abstract void makeProduct();
	
}

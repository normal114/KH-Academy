package com.test02;

public class Computer extends Product {
	
	private int serialNumber;
	
	//public Computer() {
		// super(); 부모의 기본생성자 호출이 삭제되어있다.
	//}
		
	public Computer(int productCode, String productName, int serialNumber) {
		super(productCode, productName);
		this.serialNumber = serialNumber;
	}
	
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	
	@Override
	public void makeProduct() {
		System.out.println(super.toString() + ", 제품번호 : " + serialNumber + " 컴퓨터를 생산하였습니다.");
	}
}

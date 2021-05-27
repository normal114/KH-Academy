package com.test02;

public class KHFactory {

	public static void main(String[] args) {
		System.out.println("===========KH Factory 생산 시작============");
		Product[] kh = new Product[5];

		kh[0] = new Computer(1, "KH컴퓨터", 123456);
		kh[1] = new Sugar(2, "KH설탕", "흑설탕", 5);
		kh[2] = new Computer(1, "KH컴퓨터", 112233);
		kh[3] = new Sugar(2, "KH설탕", "백설탕", 2);
		kh[4] = new Computer(1, "KH컴퓨터", 111333);
		
		for (Product product : kh) {
			product.makeProduct();
		}		
	}
}

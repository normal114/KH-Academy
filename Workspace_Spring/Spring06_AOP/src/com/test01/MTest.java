package com.test01;

public class MTest {

	public static void main(String[] args) {
		Woman w = new Woman();
		Man m = new Man();
		
		System.out.println("여학생 입장");
		w.classWork();
		System.out.println("-----");
		System.out.println("남학생 입장");
		m.classWork();
		
		// 출석한다, 집에간다 : ccc
		// 컴퓨터를 켜서 주식본다, 컴퓨터를 켜서 뉴스본다. : cc
	}
}

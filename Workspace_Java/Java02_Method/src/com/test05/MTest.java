package com.test05;

public class MTest {

	public static void main(String[] args) {
		
		// school class에 만들어 놓은 1번 2번 3번 메소드를 호출하여 console에 출력하자.
		School.namePrn("손승현");
		
		int age = School.getAge();
		System.out.println(age + "세");
		
		School kh = new School();
		kh.addrPrn("의정부시");
	}
}

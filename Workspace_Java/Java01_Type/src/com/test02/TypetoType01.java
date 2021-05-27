package com.test02;

public class TypetoType01 {

	public static void main(String[] args) {
		
		// 1. int to char
		int i = 65;
		char c = (char)i;
		System.out.println(c);
		
		// 2. char to int;
		char c2 = 'B';
		int i2 = (int)c2;
		System.out.println(i2);
		
		char c3 = '1';
		char c4 = '9';
		int i3 = c3 + c4;
		System.out.println(i3);
		
		// 3. String to int
		String str = "33";
		System.out.println(str + 1);
		int i4 = Integer.parseInt(str);
		System.out.println(i4 + 1);
		
		// 4. int to String 
		int i5 = 55;
		System.out.println(i5 + 1);
		String s5 = Integer.toString(i5);
		System.out.println(s5 + 1);
		String s6 = String.valueOf(i5);
		System.out.println(s6 + 1);
	/*
	 * 기본타입 : call by value
	 * 정수형 : byte(1) short(2) int(4) long(8) l/L
	 * 실수형 - float(4) f/F double(8) d/D
	 * 문자형 - char(2)
	 * 논리형 - boolean(1)
	 * + 문자열(참조타입 이지만, 기본타입 처럼 사용 가능) String
	 * 
	 * 참조타입 : call by reference
	 * Wrapper Class -> 기본타입을 가지고 참조타입으로 변환(가능) 
	 */
	}
	
}
		
		
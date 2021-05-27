package com.j01;

public class Type {

	public static void main(String[] args) {
		// type 변수 = 값;
		int i = 10;
		String s = "20";
		
		int res = i + Integer.parseInt(s); // String -> int 형변환
		System.out.println(res); 
		
		String s1 = new String("a"); // String 객체가 만들어 짐(객체에 들어감)
		String s2 = "a"; // 스트링 풀 안에서 논다(스트링 풀에 들어감)
		
		System.out.println(s1 == s2); 
		System.out.println(s1.equals(s2));
		
	}
}

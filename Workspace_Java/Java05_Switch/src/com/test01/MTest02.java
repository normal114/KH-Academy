package com.test01;

public class MTest02 {

	public static void main(String[] args) {
		
		// java 1.7 이후부터 문자열 가능.
		// 기존 버전에는 정수형, 문자형만 가능했었음.
		String s = "한국";
		
		switch(s) {
		case "한국":
			System.out.println("korea");
			break;
		case "중국":
			System.out.println("china");
			break;
		case "일본":
			System.out.println("japan");
			break;
			
		}

	}

}

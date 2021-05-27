package com.test01;

public class MTest {

	public static void prn02() {
		int i = 10;
		
		do { // do { } while ( )은 적어도 한 번 do 안 에 있는 명령문들을 명령하고 조건을 확인한다. <-> while문
			System.out.println(i);
			i++;
		} while(i < 10);
		
	System.out.println("while이 끝난 후의 i : " + i);
	}
		
	public static void prn03() {
		
		int i = 1;
		
		while (true) {
			System.out.	println(i);
			i++;
			
			if (i == 10) {
				break;
			}
		}
		
		System.out.println("while이 끝난 후의 i : " + i);
	}
	
	public static void main(String[] args) {
	//	prn01();
	//	prn02();
		prn03();
	}
	
	public static void prn01() {
		// 초기값
		int i = 10;
		
		// 조건식
		while(i < 10) {
			System.out.println(i);
		
			//증감식
			i++;
		}
		
		System.out.println("while이 종료된 이후의 i : " + i);
	}
}

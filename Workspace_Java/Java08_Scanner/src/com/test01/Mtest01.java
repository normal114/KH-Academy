package com.test01;

import java.util.Scanner;

public class Mtest01 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void test04() {
		//Scanner sc = new Scanner(System.in); // Scanner은 cmd랑 연결되어 있음. Scanner를 한 번 닫으면 다시 연결할 수 없기 때문에 test02, test03, test04랑 같이 실행하면 오류가 난다.test02,03,04도 scanner를 사용하기 때문. sc.close는 마지막에 사용하라.
		System.out.println("이름 :");
		String name = sc.nextLine(); // next에 들어간 엔터값 때문에 한 번 날려버릴 코드가 필요하다.
		System.out.println("별명 :");
		String nickName = sc.nextLine();
		System.out.println(name +"이름 :별명 : " + nickName);
		
	}
	
	public static void test03() {
		//Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열을 입력해 주세요.(공백 포함 불가)");
		String input = sc.next(); // sc.next는 공백을 포함하지 않기 떄문에 문장만 런한다.
		System.out.println("입력하신 문자열: " + input);
		String input2 = sc.next();
		System.out.println("text test : " + input2);
		String input3 = sc.next();
		System.out.println("text test 2 : " + input3);
		String inputLine = sc.nextLine();
		System.out.println("next");
		
	}
	
	public static void test02() {
		//Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열을 입력해 주세요. (공백 포함 가능)");
		String input = sc.nextLine(); // nextLine은 공백을 포함한다
		System.out.println("입력하신 문자열 : " + input);
	
	}
	
	
	public static void test01() {
		//Scanner sc = new Scanner(System.in);

	
	System.out.println("숫자를 입력해 주세요 :");
	int a = sc.nextInt();
	System.out.println("입력받은 a의 값 : " + a);
	
	
	System.out.println("숫자를 한 번 더 입력해 주세요 :");
	int b = sc.nextInt();
	System.out.println("입력 받은 b의 값 : " + b);
	
	int sum = a + b;
	System.out.println("두 숫자의 합은 " + sum + "입니다.");
	
	}
	
	public static void main(String[] args) {
		
		//test01();
		//test02();
		//test03();
		test04();
		
		sc.close();
	}
}

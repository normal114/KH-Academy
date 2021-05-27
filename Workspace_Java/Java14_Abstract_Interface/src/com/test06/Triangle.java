package com.test06;

import java.util.Scanner;

public class Triangle extends AreaImpl {

	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.println("밑변을 입력해 주세요 : ");
		int x = sc.nextInt();
		System.out.println("높이를 입력해 주세요 : ");
		int y = sc.nextInt();
	
		double res = (double)(x * y) / 2;
	
		// setResult(String.valueOf(res)); // double를 String으로 바꾸는 방법1
		// setResult(Double.toString(re)); // double를 String으로 바꾸는 방법2
		// setResult(res + ""); // 문자열과 다른 것이 만나면 문자열이 된다. 방법3
		setResult(String.format("%.2f", res)); // 소숫점 둘쨰짜리까지 나온다.
	}

	public void print() {
		System.out.print("삼각형의 ");
		super.print();
	}
}
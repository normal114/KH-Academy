package com.test03;

public class MyCalc {

	// 접근제한자 메모리영역 리턴타입 메소드명 (파라미터=입력)

	// 더하기
	public static int sum(int i, int j) { // 중복 int i, j가 가능한 이유는 내부에서만 쓰고 사라지기 때문. 이런 i, j는 지역변수라 한다.
		System.out.print("i : " + i + "\t j : " + j + "\t result :");
		int result = i + j;

		return result;
	}

	// 빼기
	public static void sub(int i, int j) { // return되는 값이 없을 경우는 void를 사용한다
		int result = i - j;
		System.out.printf("%d - %d = %d\n", i, j, result);
	}

	// 곱하기
	public static double mul(double d1, double d2) {
		double result = d1 * d2;

		return result;
	}

	// 나누기
	public void div(int i, int j) {
		// '/' : 나눈 값
		int div01 = i / j;
		
		// '%' : 나머지
		int div02 = i % j;
		
		System.out.printf("%d / %d = %d\n", i, j, div01);
		System.out.printf("%d %% %d = %d\n", i, j, div02);
	}

}

package com.test01;

import java.util.Arrays;

public class MTest01 {

	public static void main(String[] args) {

		// 방법 1.
		int[] a; // 선언(타입 변수)
		a = new int[5]; // 정의(값)
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		a[4] = 5;

		// 방법 2.
		int[] b = new int[] { 5, 4, 3, 2, 1 }; // 선언 정의 초기화

		// 방법 3.
		int[] c = { 6, 7, 8, 9, 10 }; // 선언 초기화

		System.out.println(a[0]); // ctrl + 소스(println같은 것)을 누르면 자바가 만든 프로그램 소스를 확인할 수 있다

		System.out.println(a[0] + b[1] + c[2]);

		System.out.println(c); // 여기서 c는 주솟값(참조변수)이다. 참조변수는 해당 변수를 호출하면 해당 변수의 주솟값이 나오게 된다.
		System.out.println(Arrays.toString(c)); // toStirng은 해당 배열의 값을 리턴시킨다.

		String[] s = new String[] { "Have", "a", "nice", "day" };

		prn(s);
		modi(s);
	}

	public static void modi(String[] arr) {
		// nice -> good 변경후 전체 출력
		// [Have, a, good, day] (Arrays.toStrng 사용 금지!)
		arr[2] = "good";
		
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			// System.out.printf("%s, ", arr[i]);
			if (i == arr.length - 1) {
				System.out.printf("%s", arr[i]);
			} else {
				System.out.printf("%s, ", arr[i]);
			}
		}
		System.out.println("]");
	}

	public static void prn(String[] arr) {
		// {Have a nice day }
		// hint! 배열은 0부터 length-1까지

		System.out.print("{");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%s ", arr[i]);
		}
		System.out.println("}");
	}

}
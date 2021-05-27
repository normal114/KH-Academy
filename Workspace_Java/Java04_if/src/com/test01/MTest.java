package com.test01;

public class MTest {

	public static void main(String[] args) {
		prn01();
		prn02(true, true);

	}

	public static void prn02(boolean ring, boolean married) {

		if (ring) {
			if (married) {
				System.out.println("결혼하셨군요!");
			} else {
				System.out.println("연인이 있으시군요!");
			}
		} else {
			if (married) {
				System.out.println("결혼하셨군요!");
			} else {
				System.out.println("솔로이셨군요!");
			}
		}

		if (ring && married) {
			System.out.println("결혼하셨군요!");
		} else if (ring || married) {
			System.out.println("연인이 있으시군요!");
		} else {
			System.out.println("솔로셨군요!");
		}

	}

	public static void prn01() {
		int i = 10;
		int j = 20;

		// if : 만약 ~~라면
		if (i < j) { // 만일 조건이 참이라면
			// bady(block) 안에 있는 명령들을 수행하자.
			System.out.println("i가 j보다 작습니다.");
		}

		// if ~ else
		if (i > j) {
			System.out.println("i는 j보다 큽니다.");
		} else {
			// 위의 조건이 참이 아니라면
			System.out.println("i는 j보다 크지 않습니다.");
		}

		// if ~ else if ~ ... ~ else
		if (i == 2) {
			System.out.println("i는 2입니다.");
		} else if (i == 3) {
			System.out.println("i는 3입니다.");
		} else if (i == 4) {
			System.out.println("i는 4입니다.");
		} else if (i == 5) {
			System.out.println("i는 5입니다.");
		} else {
			System.out.println("i는 2, 3, 4, 5가 아닙니다.");
		}
	}

}

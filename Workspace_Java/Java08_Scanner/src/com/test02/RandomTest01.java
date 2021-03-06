package com.test02;

import java.util.Random;

public class RandomTest01 {

	public static void main(String[] args) {
		useMathClass();
	
	}
	
	// java.util.Random
	public static void useRandomClass() {
		Random rd = new Random();
		System.out.println(rd.nextInt(100));
	}
	
	// java.lang.Math
	public static void useMathClass() {
		// 0 <= ran < 1 1보다 작고 0보다 큰 실수타입이 만들어진다.
		double ran = Math.random();
		System.out.println(ran);

		int min = 0;
		int max = 10;
		// (int)(Math.random() * (max - min + 1) + min;
		int rd = (int) (Math.random() * (max - min + 1)) + min; // +1하는 이유는 0~9까지 밖에 안나오기 때문이다.
		System.out.println("random : " + rd);

	}
}

/*
 * 20 ~ 30 random (30포함)
 * 20, 21, 22, ..., 29 , 30 -> 11개
 *
 * (int)(Math.random() * (max - min + 1)) + min;
 * 0 <= x < 1
 * x는 실수(0.~~~)이다 따라서 int를 사용하여 정수로 바꿔줘야 한다.
 * (30 - 20 + 1)
 * 0 < = x < 11
 * 0.0부터 10.9999~까지의 범위가 나오게 된다.
 * int로 형변화를 시켰기 때문에 0 <= x < 11 (0, 1, 2, ..., 9, 10)까지 나온다.
 * + min(20)을 하면 20 < = x < 31 (20, 21, 22, ... 29, 30) 
 */







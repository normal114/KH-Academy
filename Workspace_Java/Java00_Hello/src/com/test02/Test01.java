package com.test02;

import java.util.Scanner;
import java.util.Random;

public class Test01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] iarr = null;
		int sum = 0;

		System.out.println("배열의 크기 입력 :");
		int size = sc.nextInt();

		if (size >= 0) {
			iarr = new int[size];
		} else {
			System.out.println("배열의 크기는 양수로 입력해야 합니다.");
		}

		for (int i = 0; i < iarr.length; i++) {
			iarr[i] = new Random().nextInt(100);

			for (int j = 0; j < i; i++) {
				if (iarr[i] == iarr[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = size; i < iarr.length; i++) {
			sum += iarr[i];
		}
		System.out.println("sum = " + sum);
	}
}

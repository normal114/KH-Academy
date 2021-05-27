package com.test03;

public class SumX {

	/*
	 *  1  2  3  4  5
	 *  6  7  8  9 10
	 * 11 12 13 14 15
	 * 16 17 18 19 20
	 * 21 22 23 24 25
	 * 
	 * 이렇게 출력하고, 
	 * X의 합을 출력하자.
	 * X의 합 = 117
	 */
	
	public static void main(String[] args) {
		
		int count = 1;
		int sum = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if((i == j) || (i + j == 4)) {
					sum += count;
				}
				System.out.printf("%3d", count++);
			}
			System.out.println();
		}
		
		System.out.printf("\nX의 총 합 :" + sum);
	}
}

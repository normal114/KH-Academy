package com.test03;

import java.util.Arrays;

public class ArrCube02_H {

	/*
	 * 1 2 3 4 5
	 * 10 9 8 7 6
	 * 11 12 13 14 15
	 * 20 19 18 17 16
	 * 21 22 23 24 25
	 *
	 *모양의 이차원 배열을 만들어서 출력하자.
	 */
	
	public static void main(String[] args) {
		
		int[][] a = new int[5][5];
		int num = 1;
		for (int i = 0; i < a.length; i++ ) {
			if(i % 2 == 0) {
				for (int j = 0; j < a.length; j++) {
					a[i][j] = num;
					num++;
				}
			}
			else {
				for (int j = 4; j >= 0 ; j--) {
					a[i][j] = num;
					num++;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.printf(a[i][j]+ " ");
			}
			System.out.println();
		}
	}
}

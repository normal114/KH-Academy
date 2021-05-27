package com.test03;

import java.util.Arrays;

public class ArrCube01 {

	/*
	 * 1 4 7 
	 * 2 5 8 
	 * 3 6 9
	 *
	 * 모양의 이차원 배열을 만들어서 출력하자.
	 */

	public static void main(String[] args) {

		int[][] arr = new int[3][3];
		int cnt = 1;

		// 만들기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) { // 큰 배열 arr[i]에서 작은 배열 j를 돌리고 있는 상황이다.
				arr[j][i] = cnt++;

			}
		}

		// 출력하기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%2d", arr[i][j]);
			}
			System.out.println();
		}
	}
}

// int[][] arr = new int[3][];
//arr[0] = new int [2];
//arr[1] = new int [10];
//arr[2] = new int [5];

//for(int i = 0; i < arr.length; i++) {
//	for (int j = 0; j < arr.length; j++) { // arr[i]가 없으면 에러가 난다.큰 배열은 3인데 작은 배열은 10이라 out of bounds가 뜸.
//		System.out.println(arr[i][j];
	//}
//}
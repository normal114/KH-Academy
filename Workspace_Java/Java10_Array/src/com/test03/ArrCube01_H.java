package com.test03;

import java.util.Arrays;

public class ArrCube01_H {

	/*
	 * 1 4 7
	 * 2 5 8
	 * 3 6 9
	 */
	
	public static void main(String[] args) {
		
		int[][] arr= {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
		
		
		for (int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {

				System.out.print(arr[i][j]+" ");

		}
			System.out.println();
		}
		
	}
}
	
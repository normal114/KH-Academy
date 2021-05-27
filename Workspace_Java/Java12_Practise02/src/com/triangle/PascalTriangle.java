package com.triangle;

import java.util.Scanner;

/* 
 *        1
 *       1  1
 *     1  2  1
 *    1  3  3  1
 *   1  4  6  4  1
 * 1  5  10 10  5  1
 * ...
 *              
 */
class PascalTriangle {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("level : ");
		int n = sc.nextInt();
		
		int[][] arr = new int[n][]; 
				
		arr[0] = new int[] {1};
		for (int i = 1; i < arr.length; i++ ) {
			arr[i] = new int[i+1]; // 칸 입력 1열에 한칸 2열에 두칸 3열에 3세칸 이런 식으로 
			
			for (int j = 0; j <arr[i].length; j++ ) {
				if (j == 0 || j == arr[i].length -1) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];  // 대각선에 있는 배열을 더한다.
				}
			}
		}
		prn(arr);
	}
	
	private static void prn(int[][] arr){
		for (int i = 0; i < arr.length; i++ ) {
			for (int j = arr.length; j > i; j-- ) {
				System.out.print("  ");
			}
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
	
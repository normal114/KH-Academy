package com.test03;

public class ArrCube02 {

	public static void main(String[] args) {

		int[][] arr = new int[5][5];
		int cnt = 1;

		// 값 저장
		for (int i = 0; i < arr.length; i++) {

			// i = 0, 2, 4
			if (i % 2 == 0) {
				// 정방향
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = cnt++;
				}

			} else {
				// 역방향
				for (int j = arr[i].length - 1; j >= 0; j--) {
					arr[i][j] = cnt++;
				}

			}
		}

		// 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}
}

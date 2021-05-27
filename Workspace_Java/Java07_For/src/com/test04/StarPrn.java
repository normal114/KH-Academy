package com.test04;

public class StarPrn {
	
	// 빈 칸과 별 칸을 합치는데 별 칸이 자리 뒤로 밀리는 것이다.
  
	/* 
	 * *
	 * **
	 * ***
	 * ****
	 * *****
	 */

	public void prn01() {
		
		// i는 줄
		for (int i = 0; i < 5; i++) {
		
			// j는 * 갯수 (0+1, 1+1, 2+1, 3+1, 4+1)
			for (int j = 0; j < i + 1; j++) {
			
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	/*
	 * *****
	 * ****
	 * ***
	 * **
	 * *
	 */
	
	public void prn02() {
		
		// i는 줄
		for (int i = 0; i < 5; i++) {
			
			// j는 5-i (5-0, 5-1, 5-2, 5-3, 5-4)
			for(int j = 0; j < 5 - i; j++) {

				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}
				
	/*     *
	 *    **
	 *   ***
	 *  ****
	 * *****
	 */
	
	public void prn03() {
		
		// i는 줄
		for (int i = 0; i < 5; i++) {
			
			// j는 빈칸(4-0, 4-1, 4-2, 4-3, 4-4)
			for (int j = 0; j < 4 - i ; j++) {
				
			System.out.print(" ");

			}
			
			// k는 별(0+1, 1+1, 2+1, 3+1, 4+1)
			for (int k = 0; k < i + 1; k++) {
				System.out.print("*");
			}
		
		System.out.println();
		}
		
	}
	
	/* *****
	 *  ****
	 *   ***
	 *    **
	 *     *
	 */
	
	public void prn04() {
		
		// i는 줄
		for (int i = 0; i < 5; i++ ) {
			
			// j는 공백
			for(int j = 0; j < i; j++ ) {
				
				System.out.print(" ");
			}
			
				// k는 별
				for (int k = 0; k < 5 - i; k++ ) {
					
					System.out.print("*");
				}
				
				System.out.println();
			}
			
	}
	
		/*
		 *     *
		 *    ***
		 *   *****
		 *  *******
		 * *********
		 */

	public void prn05() {
		
		// i는 줄
		for (int i = 0; i < 5; i++ ) {
			
			// j는 공백
			for (int j = 4 - i; j > 0; j-- ) {
				
				System.out.print(" ");
			}
			
			// k는 별
			for (int k = 0; k < 2 * i + 1; k++ ) {
				
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
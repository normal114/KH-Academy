package com.test01;

import java.util.Arrays;

public class MTest03 {

	/*
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z 출력! 단, 일차원 배열에, 반복문을 사용하여
	 * 알파벳을 저장한 후에 출력하자.
	 */

	public static void main(String[] args) {

		char[] ch = new char[26];
		for (int i = 0; i < ch.length; i++) {
			ch[i] = (char) ('a' + i);
		}
		System.out.println(Arrays.toString(ch));

		for (int i = 1; i <= ch.length; i++) {
			System.out.print(ch[i - 1] + " ");
			if (i % 6 == 0) {
				System.out.println();
			}
		}

		System.out.println("\n");
		// 2) 1번에서 만든 배열을 거꾸로 출력하자.
		int tmp = 1; // tmp를 만든 이유는 zyx 다음에 엔터가 쳐지기 때문에 1-6을 넣어야 zyxwvu식으로 된다.

		for (int i = ch.length; i > 0; i--) {
			System.out.printf("%s ", ch[i - 1]);  // i - 1을 하는 이유는 i=length(26)인데 index는 25까지 이기 때문이다.
			if (tmp % 6 == 0) {
				System.out.println();
			}

			tmp++;
		}

		System.out.println("\n");

		// 3) 1번에서 만든 배열을 대문자로 바꾸어 출력
		int cnt = 1;
		for (int i = 0; i < ch.length; i++) {
			ch[i] = Character.toUpperCase(ch[i]);
			System.out.printf("%s ", ch[i]);

			if (cnt % 6 == 0) {
				System.out.println();
			}
			cnt++;

		}
	}
}
// systemoutprint((char)(ch[i] = 32));이건 아스키코드
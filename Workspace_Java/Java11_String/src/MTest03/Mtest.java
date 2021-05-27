package MTest03;

import java.util.StringTokenizer;

public class Mtest {

	public static void main(String[] args) {
		String str = "The String class represents character strings.";
		String str02 = "The,String,,class,represents,character,strings."; // ,, split는 빈칸으로 계산하는데 토큰은 여기를 인식 못함.

		// 1. java.lang.String.substring(begin, end - 1) *end Index에서 -1 해주는 것이 중요하다.
		System.out.println(str.substring(4, 10));

		// 2. java.lang.String.split
		String[] temp = str02.split(",");
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
		System.out.println(temp[2]);

		System.out.println("-----------------------------");
		// 3. java.util.StringTokenizer
		StringTokenizer st = new StringTokenizer(str02, ",");

		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
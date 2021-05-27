package com.test03;

public class PrnTest {

	/*
	 * System.out.print() - 줄 바꿈 없음
	 * System.out.println() - 줄 바꿈 포함
	 * 
	 * System.out.printf(String format, Object, Object, ... args)
	 * java.util.Formatter
	 */
	public static void main(String[] args) {
		int i = 100;
		
		System.out.print("1. i: \\" + i + "\n");
		System.out.println("2. i: \t" + i);
		System.out.printf("3. i: %10d", i);
		System.out.println("-----------");
		
		// 시험 점수 결과는 100(su)점 이고, 학점은 'A(ch)'가 나왔다.
		
		int su = 100;
		char ch = 'A';
		double d = 90.50d;
		
		System.out.printf("시험 점수 결과는 %10d점 이고, 학점은 '%5c' 가 나왔다.\n나의 오늘 감정지수는 %5.2f%%이다.", su, ch, d);
	
		int age = 36;
		String name = "손승현";
		System.out.printf("오늘은 11\\"+"24입니다. 제 나이는 %d입니다. 제 이름은 %s입니다.", age, name);
	}
}



































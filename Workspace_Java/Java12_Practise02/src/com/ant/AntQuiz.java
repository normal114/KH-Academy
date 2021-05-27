package com.ant;

import java.util.Scanner;

/*
 * 1
 * 11
 * 12
 * 1121
 * 122111
 * 112213
 * 12221131
 * 1123123111
 * 12213111213113
 * ...
 * 
 */
public class AntQuiz {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("개미수열");
		System.out.println("몇 줄을 출력하시겠습니까?");
		int n = sc.nextInt();

		String line = "1";
		String next = "";

		for (int i = 0; i < n; i++) {
			System.out.println(line);
			next = nextLine(line);
			line = next;

		}
		sc.close();
	}

	public static String nextLine(String line) {

		String next = "";

		for (int i = 0; i < line.length(); i++) {
			if (i > 0) {
				if (line.charAt(i) == line.charAt(i - 1)) {
					continue;

				}
			}
			next += numberCnt(line, 1);
		}

		return next;

	}

	private static String numberCnt(String line, int n) {
		
		char str = line.charAt(n);
		int count = 0;
		
		for (int i = n; i < line.length(); i++) {
			if (str == line.charAt(i)) {
				count++
			} else {
				break;
				}
		}
			return str + Integer.toString(count);
						
	}
	return null;
}

package com.test02;

import java.util.Arrays;

public class DeepCopy {

	// 새로운 객체 생성해서, 값만 복사
	public static void main(String[] args) {
		
		int[] original = {10, 20, 30, 40, 50};
		
		// 1. 배열 인덱스의 값을 가져와서 복사
		int[] copy01 = new int[original.length]; // original의 값을 copy에 새로 만듦.(new가 붙음)
		for (int i = 0; i < original.length; i++) {
			copy01[i] = original[i]; // 값만 같고 주소는 다름. 약간 덮어쓰기가 아니라 붙여넣기 느낌
		}
		
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy01));
		System.out.println(original);
		System.out.println(copy01);
		System.out.println(original == copy01);
		
		copy01[2] = 300;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy01));
		
		System.out.println("-------");
		// 2. original에게 요청하여 복사
		int[] copy02 = original.clone();
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy02));
		
		copy02[2] = 3000;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy02));
	
		System.out.println(original);
		System.out.println(copy02); // 주소값이 달라짐. 새로 복사한 것
	
		System.out.println("-------");
		// 3. System.arrayCopy 사용
		int[] systemArr = new int[10];
		Arrays.fill(systemArr, 100); // 해당 배열에 전부 배열을 채워놓자.
		System.out.println(Arrays.toString(systemArr));
		
		//              (원본,     시작,      복사본, 시작, 갯수
		System.arraycopy(original, 0, systemArr, 1, 3);
		System.out.println(Arrays.toString(systemArr));
		
		
	}
}
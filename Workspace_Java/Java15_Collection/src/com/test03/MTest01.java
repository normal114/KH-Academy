package com.test03;

import java.util.HashSet;
import java.util.Set;

public class MTest01 {

	// Set : 순서 x, 중복 x
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("1");
		set.add("3");
		set.add("5");
		set.add("2");
		set.add("4");
		set.add("6");
		set.add("7");
		// set.add(null);			// 저장은 가능하나, 사용하면 NullPointerException 에러가 발생함.
		set.add("3");				// 3은 한 번 출력. 중복이 안된다. 
		
		
		for (String s : set) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		findElement(set, "3");
		deleteElement(set, "3");
		
	}
	
	public static void deleteElement(Set<String> set, String delete) {
		for (String s : set) {
			if (s.equals(delete)) {
				// 원래는 remove이 boolean type이라 if (s.equals(delete)) {를 넣어줘야 했지만 굳이 넣어주지는 않았다.
				set.remove(s);  // 내가 가지고 있는 게 바뀌어서 에러가 나는 것은 modification error!! 따라서 break;를 써야 한다.
				System.out.println(delete + " 지웠다!!"); 
				break;
			}
		}
		System.out.println(set);
	}
	
	public static void findElement(Set<String> set, String find) {
		/*
		for (int i = 0; i < set.size(); i++ ) {
			set.get(i);

		}
		*/
		for (String s : set) {
			if (s.equals(find)) {
				System.out.println(find + " 찾았다!!");
			}
		}
	}
}

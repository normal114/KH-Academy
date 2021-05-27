package com.generic;

import java.util.ArrayList;
import java.util.List;

public class MTest02 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		// list.add(3);
		list.add("4");
		list.add("5");
		// list.add('6');s
		for (int i = 0; i < list.size(); i++) {
			System.out.println(((String)list.get(i)).getBytes()); 
			// Byte타입으로 바꿔야 하는데 문자열이나 문자가 있어서 Byte로 바꾸기 힘들다. 따라서 이런 경우 지네릭을 사용한다.
		}
	}
}

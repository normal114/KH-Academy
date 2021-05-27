package com.teat01;

import java.util.Vector;

public class MTest01 {

	public static void main(String[] args) {
		
		// Vector(iCa, cpIn)
		// iCa만큼 용량(capacity)를 만든다. iCa를 넘어가면 cpIn만큼 용량이 증가한다.
		Vector<Integer> v = new Vector<Integer>(10, 5);
		System.out.println(v.size() + " : " + v.capacity());
	
		for (int i = 0; i < 9; i++ ) {
			v.add(i);
			System.out.println(v + " : " + v.size() + " : " + v.capacity());
		}
		
		v.add(9);
		System.out.println(v + " : " + v.size() + " : " + v.capacity());
		
		v.add(10);
		System.out.println(v + " : " + v.size() + " : " + v.capacity());
		v.remove(0); // 사이즈를 줄인다.
		System.out.println(v + " : " + v.size() + " : " + v.capacity());
		
	}
}

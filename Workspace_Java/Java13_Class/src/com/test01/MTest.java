package com.test01;

public class MTest {

	public static void main(String[] args) {
		AA a = new AA();
		Super s = a; 			// 부모 클래스에 있는 super s에다가 자식 클래스에 있는 a가 가진 new AA()한 "instance"의 주소값 대입
		// BB b = (BB) s;			// s에 담긴 AA instance를 BB로 형변환 불가(자식 객체끼리는 변환이 불가능하다.) 자식이 부모 타입으로 바뀌는 것도 안 된다. 
		
		System.out.println(a.hashCode());
		System.out.println(s.hashCode());
		
	}
}

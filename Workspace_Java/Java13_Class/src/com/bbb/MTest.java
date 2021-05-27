package com.bbb;

import com.aaa.AAA;

public class MTest {

	public static void main(String[] args) {
		// type 변수 = 값;
		// type 변수 = new 생성자();
		AAA myA = new AAA(); // 앞의 AAA는 참조타입, 참조타입의 값은 instance(객체), 뒤의 AAA는 생성자, 클래스를 객체로 만드는 것은 생성자이다.
		myA.prn();
		AAA paramA = new AAA(10);
		paramA.prn();
		System.out.println("abc : " + paramA.getAbc()); // get은 자료 가져올게
		paramA.setAbc(100); // set은 값을 넣어줄게
		System.out.println("abc : " + paramA.getAbc());
		System.out.println("=======================================");
		BBB b1 = new BBB(); // 부모 생성자를 호출해서 객체(AAA())가 먼저 만들어 진 후, 자식 생성자를 호출해서 객체(BBB())가 만들어진다. 그리고 부모 주소값을 가지고 있다. AAA()와 BBB()는 묶여 있기 때문이다.
		b1.setAbc(10);
		b1.setBcd(20);
		System.out.println(b1.getSum());
		
		BBB b2 = new BBB(15);
		System.out.println(b2.getSum());
		
		BBB b3 = new BBB(20, 50); // BBB 자식 클래스의 super를 통해 AAA부모 클래스 abc로 거슬러 올라간다.(호출된다.)
		System.out.println(b3.getSum());
		System.out.println("=======================================");
		
		AAA a1 = new AAA();
		AAA a2 = new BBB(); // AAABBB가 나오는 이유는 자식은 부모랑 묶여있어서...
		// BBB a3 = new AAA();  // 부모 타입으로 자식 객체를 받을 수 있지만 자식 타입으로 부모 객체를 받을 수는 없다.
		a1.prn();
		a2.prn(); // a2.prn();은 부모의 메소드(a1.prn();)을 통해서 자식의 메소드(prn();)가 호출된다.
		a2.getAbc();
		// a2.getBcd(); // getBcd를 쓸 수 없는 이유는 AAA는 Bcd가 없기 때문이다.
		((BBB)a2).getBcd(); // BBB의 Bcd를 쓰려면 왼쪽과 같이 자식 타입(BBB)으로 형변환을 시켜야 한다.
	}
}
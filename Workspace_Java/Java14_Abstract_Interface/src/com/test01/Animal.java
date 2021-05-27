package com.test01;


// abstract class(추상 클래스) : 하나 이상의 추상 메소드를 가질 수 있는 클래스
public abstract class Animal {

	// abstract method (추상 메소드) : body(block) 없는 메소드 -> 상속받는 자식 클래스에서 반드시 구현!
	// 추상클래스는 기능을 구현 못함. new 연산자를 만들지도 못함. 
	public abstract void bark();
	
	public void eat(String feed) {
		System.out.println(feed + "먹는다.");
	}
}

package com.test01;

public class Cat extends Animal {

	@Override
	public void bark() { // 추상클래스는 new 연산자를 사용할 수 없다.
		System.out.println("야옹");
	}

	@Override
	public void eat(String feed) {
		System.out.print("고양이가 ");
		super.eat(feed);
	}
}
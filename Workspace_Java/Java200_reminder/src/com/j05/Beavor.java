package com.j05;

public class Beavor extends Animal {
	
	// 생성자를 명시하지 않으면, jvm 기본생성자를 제공한다.
	// 기본생성자에, 부모 생성자를 호출하지 않으면, 자동으로 부모의 기본생성자를 호출하게 된다.
	// 그래서, Animal의 기본생성자를 호출하게 되는데 -> 이 때, 부모의 기본생성자가 없어서 에러 발생.
	
	public Beavor(String kind, int age) {
		super(kind, age);
		// TODO Auto-generated constructor stub
	}

	public void bark(String bark) {
		System.out.print("비버의");
		super.bark(bark);
		
	}
}

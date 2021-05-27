package com.test01;

public class Mtest {

	public static void main(String[] args) {
		// Animal animal = new Animal(); // Animal은 추상메서드를 가진 추상클래스이기 때문에 바디가 없어서 실행이 안된다.
		Animal cat = new Cat();
		Animal dog = new Dog();
		
		cat.bark();
		dog.bark();
	
		cat.eat("생선");
		dog.eat("뼈다귀");
		
	}
}

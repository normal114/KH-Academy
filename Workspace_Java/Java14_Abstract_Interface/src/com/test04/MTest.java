package com.test04;

public class MTest {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.bark();
		cat.eat("참치");
		
		Dog dog = new Dog();
		dog.bark();
		dog.eat("갈비");
		
		Eagle eagle = new Eagle();
		eagle.fly();
		eagle.bark();
		eagle.eat("쥐");
	}
}

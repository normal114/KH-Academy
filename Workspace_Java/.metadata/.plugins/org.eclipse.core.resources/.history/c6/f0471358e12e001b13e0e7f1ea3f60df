package com.test02;

public class MTest {

	public static void main(String[] args) {

		FruitBasket bananaBasket = new FruitBasket(); // new FruitBacket() => 인스턴트
		bananaBasket.backetSetting("바나나", 10);
		
		FruitBasket.basketSize = 20; //이게 올바른 접근
		// bananaBasket.basketSize = 15; // instance가 static class를 모조리 바꿔버렸음.
		System.out.println(bananaBasket.basketSize);
		// FruitBasket.count = 100; 논스태틱은 사용할 수 없다.
		System.out.println(bananaBasket.fruitName);
		
		FruitBasket appleBasket = new FruitBasket();
		appleBasket.backetSetting("사과", 21);
		System.out.println(appleBasket.basketSize);
		System.out.println(appleBasket.fruitName);
		
		
		FruitBasket pearBasket = new FruitBasket();
		pearBasket.backetSetting("배", 1);
		System.out.println(pearBasket.basketSize);
		System.out.println(pearBasket.fruitName);
		
		// static -> instance : 참조(호출) 할 수 없다.
		// instance -> static : 참조(호출) 할 수 있다. 하지만 되도록 하지 말자.(해당 클래스 전체가 바뀌기 때문)
		// instance -> instance : 참조 할 수 있다.
	}
}

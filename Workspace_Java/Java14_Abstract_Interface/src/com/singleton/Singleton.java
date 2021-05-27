package com.singleton;

// singleton pattern : 메모리(heap)에 객체를 한번만 생성
public class Singleton {
//             참조타입
	// 2. 객체를 확인할 주소(reference) 변수 선언
	private static Singleton singleton;
	//               참조타입     변수
	
	// 1. 생성자를 외부에서 사용할 수 없도록 private으로 선언
	private Singleton() { // private 생성자. 외부에서 new로 생성할 수 없음.
		System.out.println("singleton instance 생성");
	}
	
	// 3. 객체가 heap에 있는지 확인
	// 있으면 주소값 리턴, 없으면 새로운 객체 생성
	public static Singleton getInstance() {  // 객체생성. private이기 때문에 new를 생성할 수 없다.
		if(singleton == null) {
			singleton = new Singleton();
			System.out.println("new!");
		} else {
			System.out.println("exist!");
		}
		
		return singleton;
	}
}

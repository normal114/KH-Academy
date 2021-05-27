package com.test01;

public class MethodTest02 {

	public static void main(String[] args) {
		// method 호출 방법
		// 1. static method : class.method();
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
		// MethodTest01.privateMethod();			// private method는 해당 class 내에서만 (not visible)
		// MethodTest01.abc();				// abc는 없다 (undefined)
		
		
		// 2. non-static method
		// class(참조타입) 변수 = new class();
		// 변수.method();
		
		MethodTest01 method01 = new MethodTest01();		// 생성자, 값(객체)
		//타입 변수 = 값
		method01.nonStaticMethod();
		
		// objectaid (google -> objectaid 검색 -> Help -> InstallNewSoftware... -> name이랑 url주소 복사붙여넣기
	
	}
}

package com.j02;

public class MTest {

	public static void main(String[] args) {
	
	MyMethod.myPublic();
	MyMethod.myProtected();
	MyMethod.myDefault();
	// MyMethod.myPrivate();
	
	MyMethod my = new MyMethod();
	my.myNonStatic();

	}
}

	// static stack heap이 있다.
	// static class가 만들어져 있다.
	// NonStatic는 heap에서 객체로 만들어져야 호출할 수 있다.
	
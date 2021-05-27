package com.test06;

public abstract class AreaImpl implements Area {

	private String result;
	
	@Override
	public void print() {
		// super.PRINT X -> super:부모"객체" super이 아닌 Area를 쓰는 이유는 클래스가 아니라 interface라서...
		// Area.PRINT = "abcd"; X -> static final  상수는 전부 대문자로 쓴다.
		// 인터페이스에 변수를 집어 넣으면 저절로 상수로 변한다.
		System.out.println(Area.PRINT + result);
	}

	@Override
	public abstract void make();

	public void setResult(String result) {
		this.result = result;
	}
	
}

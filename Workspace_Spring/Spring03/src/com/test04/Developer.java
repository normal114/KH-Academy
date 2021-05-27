package com.test04;

public class Developer {

	private Emp emp;
	private String dept;
	
	public Developer() {
	
	}
	// 첫번째 타입 Emp 타입이고, 두번째 타입 String 타입. 그러면 Emp 타입은 어떻게 값을 넣을 것인가? ref=""를 사용한다.
	public Developer(Emp emp, String dept) {
		this.emp = emp;
		this.dept = dept;
		
	}
	
	@Override
	public String toString() {
		return emp + " \t 부서 : " + dept;
		
	}
	
}

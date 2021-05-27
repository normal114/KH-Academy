package com.test03;

public class Developer extends Emp {

	private String dept;
	
	public Developer() {
	}
	
	public Developer(String name, int salary) {
		super(name, salary);
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return super.toString() + " 부서 : " + dept;
		// 부모의 toString(이름, 월급) + 부서 값이 합쳐진다.
	}
}

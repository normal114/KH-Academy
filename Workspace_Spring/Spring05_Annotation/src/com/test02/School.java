package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {

	// byType -> byName
	@Autowired // 자동으로 객체 연결. 
	@Qualifier("lee") // 만약 두 개가 있다면 어떤 것을 연결할 지 선택해 준다.
	private Student person;
	
	private int grade;

	public School() {
		
	}

	public School(Student person, int grade) {
		this.person = person;
		this.grade = grade;
	}

	public Student getPerson() {
		return person;
	}

	public void setPerson(Student person) {
		this.person = person;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}
	
	
	
}

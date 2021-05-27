package com.j04;

public class Person {

	private String name;
	private int age;
	private char gender;
	
	public Person() {
		
	}
	
	public Person(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public char getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "[" + name + "] \t" + age + "(" + gender + ")";
	}
	
}

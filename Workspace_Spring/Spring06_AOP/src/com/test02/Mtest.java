package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Student m = factory.getBean("man", Student.class);
		Student w = (Student) factory.getBean("woman");
		
		System.out.println("남학생 입장");
		m.classWork();
		System.out.println("-----");
		System.out.println("여학생 입장");
		w.classWork();
	}
}

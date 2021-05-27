package com.test01;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");

		System.out.println("-----------------------------------------");
		
		// Date today = new Date(); -> 스프링을 배우기 전까지는 왼쪽과 같이 사용하였다.
		Date today = (Date) factory.getBean("today");
		System.out.println(today.toLocaleString());
		
		Date end = (Date) factory.getBean("end");
		System.out.println(today.toLocaleString());
		
		MyClass myclass = (MyClass) factory.getBean("myclass");
		myclass.prn();
		
		

	}
}

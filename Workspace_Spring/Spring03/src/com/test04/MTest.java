package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/beans.xml");
		
		// lee-ss를가져오면 형변환을 해야 한다. Object타입이기 때문이다.
		// (Developer)로 형변환 하기 귀찮으면 Developer.class를 사용하면 된다.
		// Developer.class타입, 즉 Developer 타입이라는 것을 알려주고 있다.
		Developer lee = factory.getBean("lee-ss", Developer.class);
		
		Engineer hong = (Engineer) factory.getBean("hong-gd");
		
		System.out.println(lee);
		System.out.println(hong);
	}
}

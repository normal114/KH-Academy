package com.test04;

public class Man implements Student {

	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 뉴스본다.");
		// 일부로 에러를 발생시켜서 afterThrowing을 발생시킨다. null에는 length값이 없다. 쉬는날이었다...
		//String t = null;
		//t.length();
		return "스프링 연습";
	}
	
}

package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	@Before("execution(public * *(..))")
	public void before(JoinPoint join) {
		System.out.println("출석한다.");
	}
	
	// 성공을 했든 실패를 했든 무조건 뜬다.
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
	
	// 성공적으로 실행되면 리턴 된 값을 받아준다.
	@AfterReturning(pointcut = "execution(public * *(..))", returning = "returnVal")
	public void returning(JoinPoint join, Object returnVal) {
		System.out.println(returnVal + " 열심히 하는 날이었다.");
	}
	
	// 에러가 나면 AfterThrowing이 실행된다. 
	@AfterThrowing("execution(public * *(..))")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는날이었다...");
	}
}

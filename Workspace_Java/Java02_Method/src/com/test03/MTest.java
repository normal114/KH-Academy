package com.test03;

public class MTest {

	public static void main(String[] args) {
		int mySum = MyCalc.sum(10, 2); // 메소드 외부에서 변수를 만들어주는 변수를 agument, 메소드 외부에서 받은 변수를 메소드 내부에서 입력 하는 것을 parameter
		System.out.println(mySum);

		MyCalc.sub(10, 3);

		double myMul = MyCalc.mul(10, 3);
		System.out.println(myMul);

		MyCalc calc = new MyCalc();
		calc.div(10, 3);
		
		
	}

}

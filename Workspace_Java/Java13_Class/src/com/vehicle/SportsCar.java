package com.vehicle;

public class SportsCar extends Car {

	public SportsCar()
	{
		System.out.println("sportcar 새성");
	}

	public SportsCar(String color) {
		super(color);
		System.out.println(color + "색 sportscar 생성");
	}

	@Override
	public void accelPedal() {
		// speed = speed + 20; set이 20을 넣어주고 get은 가져온다.
		setSpeed(getSpeed() + 20);
		System.out.println("속도가 20 올라갑니다.");
	}

	public void breakPedal() {
		setSpeed(getSpeed() - 20);
		if (getSpeed() > 0) {
			System.out.println("속도가 20 줄어듭니다.");
		} else {
			setSpeed(0);
			System.out.println("멈췄습니다.");
		}
	}
}
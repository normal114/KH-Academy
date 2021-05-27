package com.vehicle;

public class Truck extends Car {

	public Truck()
	{
		System.out.println("truck 생성");
	}

	public Truck(String color) {
		super(color);
		System.out.println(color + " truck 생성");
	}

	@Override
	public void accelPedal() {
		// speed = speed + 15; set이 15을 넣어주고 get은 가져온다.
		setSpeed(getSpeed() + 15);
		System.out.println("속도가 15 올라갑니다.");
	}

	public void breakPedal() {
		setSpeed(getSpeed() - 15);
		if (getSpeed() > 0) {
			System.out.println("속도가 15 줄어듭니다.");
		} else {
			setSpeed(0);
			System.out.println("멈췄습니다.");
		}
	}
}
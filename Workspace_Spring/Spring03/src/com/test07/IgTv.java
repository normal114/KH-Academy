package com.test07;

public class IgTv implements TV {

	
	
	public IgTv() {
	System.out.println("IgTv 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("ig tv on");

	}

	@Override
	public void powerOff() {
		System.out.println("ig tv off");

	}

	@Override
	public void volumeUp() {
		System.out.println("ig tv volume up");

	}

	@Override
	public void volumeDown() {
		System.out.println("ig tv volume down");

	}

}

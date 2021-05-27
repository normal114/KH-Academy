package com.test03;

import org.springframework.stereotype.Component;

// IgTV igTV = new IgTV();
@Component
public class IgTV implements TV {

	public IgTV() {
		
	}
	
	@Override
	public void powerOn() {
		System.out.println("ig tv power on");

	}

	@Override
	public void powerOff() {
		System.out.println("ig tv power off");

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

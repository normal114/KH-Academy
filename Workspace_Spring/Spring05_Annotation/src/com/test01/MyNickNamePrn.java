package com.test01;

public class MyNickNamePrn {

	private NickName nickName;

	public MyNickNamePrn() {

	}

	public MyNickNamePrn(NickName nickName) {
		this.nickName = nickName;
	}

	public NickName getNickName() {
		return nickName;
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "제 별명은 " + nickName + "입니다.";
	}
	
	
}

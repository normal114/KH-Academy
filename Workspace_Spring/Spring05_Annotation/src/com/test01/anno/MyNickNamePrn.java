package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// <bean id="myNickName" class="com.test01.anno.MyNickName" />
@Component("myNickName")
public class MyNickNamePrn {

	@Autowired
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

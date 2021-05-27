package com.dto;

// Data Transfer Object : 값(Data) 전달 객체이다. MVC간의 각각의 계층(레이어)에서 값을 전달해주는 역할을 한다. 
// Value Object (VO랑 DTO를 같이 쓰는 사람이 있는데 거의 같지만 다른 측면도 있다)
// db table의 row 한 개를 저장할 수 있다.
public class MYTestDto { // DB 또는 내가 전달하고자 하는 값을 한 번에 묶어준다.(여러 개의 row 내용을 하나로 묶는다.)

	
	private int mno; // mytest에서 mno가 number타입으로 되어있었기 때문에. // 로우 
	private String mname;
	private String nickname;
	
	// 기본생성자, 파람 3개 생성자
	public MYTestDto() {
	
	}
	public MYTestDto(int mno, String mname, String nickname) {
		this.mno = mno;
		this.mname = mname;
		this.nickname = nickname;
	}
	
	// getter & setter
	public int getMno() {
		return this.mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;	
	}
}

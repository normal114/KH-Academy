package com.mvc.upgrade.model.dto;

public class MYMemberDto {

	private int memberno;
	private String memberid;
	private String memberpw;
	private String membername;
	private String memberaddr;
	private String memberphone;
	private String memberemail;
	private String memberenabled;
	private String memberrole;

	public MYMemberDto() {
		
	}

	public MYMemberDto(int memberno, String memberid, String memberpw, String membername, String memberaddr,
			String memberphone, String memberemail, String memberenabled, String memberrole) {
		this.memberno = memberno;
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.membername = membername;
		this.memberaddr = memberaddr;
		this.memberphone = memberphone;
		this.memberemail = memberemail;
		this.memberenabled = memberenabled;
		this.memberrole = memberrole;
	}

	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMemberpw() {
		return memberpw;
	}

	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberaddr() {
		return memberaddr;
	}

	public void setMemberaddr(String memberaddr) {
		this.memberaddr = memberaddr;
	}

	public String getMemberphone() {
		return memberphone;
	}

	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}

	public String getMemberemail() {
		return memberemail;
	}

	public void setMemberemail(String memberemail) {
		this.memberemail = memberemail;
	}

	public String getMemberenabled() {
		return memberenabled;
	}

	public void setMemberenabled(String memberenabled) {
		this.memberenabled = memberenabled;
	}

	public String getMemberrole() {
		return memberrole;
	}

	public void setMemberrole(String memberrole) {
		this.memberrole = memberrole;
	}

}

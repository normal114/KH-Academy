package com.hello.mvc2.dto;

public class AddressDto {

	private String name;
	private String addr;
	private String phone;
	public AddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressDto(String name, String addr, String phone) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "AddressDto [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}
	
	
}

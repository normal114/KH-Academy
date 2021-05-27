package com.mvc.semi.board.dto;

public class SmarteditorDto {

	private MultipartRequest filedate;
	private String callback;
	private String callback_func;

	public SmarteditorDto() {

	}

	public SmarteditorDto(MultipartRequest filedate, String callback, String callback_func) {
		this.filedate = filedate;
		this.callback = callback;
		this.callback_func = callback_func;
	}

	public MultipartRequest getFiledate() {
		return filedate;
	}

	public void setFiledate(MultipartRequest filedate) {
		this.filedate = filedate;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getCallback_func() {
		return callback_func;
	}

	public void setCallback_func(String callback_func) {
		this.callback_func = callback_func;
	}

}

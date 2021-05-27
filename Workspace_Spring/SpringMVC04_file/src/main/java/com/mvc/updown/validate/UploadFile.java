package com.mvc.updown.validate;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

	// 일반적인 DTO를 만든다.

	private String name;
	private String desc;
	private MultipartFile mpfile; 
	// MultipartFile 요청은 
	// 큰 파일을 청크 단위로 쪼개서 효율적으로 파일 업로드 할 수 있게 해준다.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public MultipartFile getMpfile() {
		return mpfile;
	}

	public void setMpfile(MultipartFile mpfile) {
		this.mpfile = mpfile;
	}

}

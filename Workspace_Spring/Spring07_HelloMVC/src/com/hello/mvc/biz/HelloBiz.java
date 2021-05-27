package com.hello.mvc.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.mvc.dao.HelloDao;

@Service
public class HelloBiz {

	// TODO : 06.Dao(@Repository) 호출
	@Autowired
	private HelloDao dao;
	
	public String getHello() {
		// TODO : 08.Biz에서 return
		return "Hello, " + dao.getHello();
	}
}

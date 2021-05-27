package com.cal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cal.dao.CalDao;

import net.sf.json.JSONObject;


@WebServlet("/count.do")
public class CalCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		String id = request.getParameter("id"); // calendar.jsp의 ajax에서 보냄
		String yyyyMMdd = request.getParameter("yyyyMMdd");
		System.out.printf("id : %s / yyyyMMdd : %s \n", id, yyyyMMdd); 
		
		CalDao dao = new CalDao();
		int count = dao.getCalViewCount(id, yyyyMMdd);
		System.out.println("count : " + count);
		
		Map<String, Integer> map = new HashMap<String, Integer>(); // HashMap은 Map의 인터페이스 상속, 빠른 검색
		map.put("calcount", count);
		
		// map -> json
		JSONObject obj = JSONObject.fromObject(map); // map 가져다가 Json 형태로 바꿀 것이다.
		
		// response
		PrintWriter out = response.getWriter();
		obj.write(out); // 원래는 out.println으로 썼다.
		
	
	
	
	}

}

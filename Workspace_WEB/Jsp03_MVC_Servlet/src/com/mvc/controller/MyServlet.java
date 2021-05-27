package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.biz.MVCBoardBiz;
import com.mvc.biz.MVCBoardBizImpl;
import com.mvc.dto.MVCBoardDto;

@WebServlet("/MyServlet") // web.xml의 이름과 달라야 한다. eclipse가 이것과 xml의 이름과 헷갈려서 뻗어버린다.
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		MVCBoardBiz biz = new MVCBoardBizImpl();

		String command = request.getParameter("command");
		System.out.println("[" + command + "]");

		if (command.equals("list")) {
			// 1. 보내준 값 있으면 받기
			// 2. db 호출 (전달할 값 있으면 전달)
			List<MVCBoardDto> list = biz.selectList();
			// 3. 화면에 보내줄 값 있으면 request객체에 담기
			request.setAttribute("list", list);
			// 4. 보내기
			dispatch(request, response, "mylist.jsp");
			// controller.jsp에서는 pageContext.forward("mylist.jsp"); 형태로 보냈었다.
		
		} else if (command.equals("insertform")) {
			// 1.
			// 2.
			// 3.
			// 4.
			response.sendRedirect("myinsert.jsp");
		
		} else if (command.equals("insertres")) {
			// 1.
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			// 2.
			MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
			int res = biz.insert(dto);
			// 3.
			// 4.
			if (res > 0) {
				// request.setAttribute("list", biz.selectList());
				// dispatch(request, response, "mylist.jsp");
				// 위의 코드를 치면 새로고침 할 때마다 똑같은 글이 자꾸 추가된다.
				response.sendRedirect("myservlet.do?command=list");

			} else {
			//	response.sendRedirect("myinsert.jsp");
			response.sendRedirect("myservlet.do?command=insertform");
			}
			
		} else if (command.equals("selectone")) {
			// 1. 
			int seq = Integer.parseInt(request.getParameter("seq"));
			// 2. db 호출
			MVCBoardDto dto = biz.selectOne(seq);
			// 3. 
			request.setAttribute("dto", dto);
			// 4. 
			dispatch(request, response, "myselect.jsp");
			
		} else if (command.equals("updateform")) {
			// 1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			// 2.
			MVCBoardDto dto = biz.selectOne(seq);
			// 3.
			request.setAttribute("dto", dto);
			// 4.
			dispatch(request, response, "myupdate.jsp");
			
		} else if (command.equals("updateres")) {
			// 1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			// 2.
			MVCBoardDto dto = new MVCBoardDto(seq, null, title, content, null);
			int res = biz.update(dto);
			// 3.
			// 4.
			if (res > 0) {
				response.sendRedirect("myservlet.do?command=selectone&seq=" + seq);
			} else { 
				response.sendRedirect("myservlet.do?command=updateform&seq=" + seq);
			}
			
		} else if (command.equals("delete")) {
			// 1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			// 2.
			int res = biz.delete(seq);
			// 3.
			// 4.
			if (res > 0) {
				response.sendRedirect("myservlet.do?command=list");
			} else {
				response.sendRedirect("myservlet.do?command=selectone&seq=" + seq);
			}
		}
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		// 여기서도 forward하고 있다.

	}

}

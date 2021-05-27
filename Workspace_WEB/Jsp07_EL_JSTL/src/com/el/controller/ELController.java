package com.el.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.el.dto.Score;

/**
 * Servlet implementation class ELController
 */
@WebServlet("/ELController") // 얘는 그대로 냅둔다.
public class ELController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ELController() {
    	System.out.println("생성!");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); // 여기다 써 놓아야 한다.
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 만약 doPost(request, response); 만약 여기다 쓰면 무한 루프에 빠진다. Post로 요청받았는데 또 Post로 보내고 하기 때문이다.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("[" + command + "]");

		if (command.equals("el")) {
			response.sendRedirect("basic-arithmetic.jsp");
		} else if (command.equals("eltest")) {
			Score score = new Score("홍길동", 100, 100, 100);
			
			request.setAttribute("score", score);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("eltest.jsp");
			dispatch.forward(request, response);
			
		} else if (command.equals("jstl")) {
			List<Score> list = new ArrayList<Score>();
			
			for (int i = 10; i < 50; i += 10 ) {
				Score sc = new Score("이름"+i, 50+i, 50+i, 50+i);
				list.add(sc);
			}
			
			request.setAttribute("list", list); // request로 list 값을 담는다.
			RequestDispatcher dispatch = request.getRequestDispatcher("jstltest.jsp"); // jstltest.jsp로 값을 보낸다.
			dispatch.forward(request, response);
		
		} else if (command.equals("usebean")) {
			response.sendRedirect("usebean.jsp");
		}
	}
}

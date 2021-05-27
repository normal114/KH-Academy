package com.scope.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ScopeController")
public class ScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String requestId = request.getAttribute("requestId") + ""; // index의 request 객체와 다른 얘이다.
		request.setAttribute("requestId", requestId);
		
		HttpSession session = request.getSession();
		String sessionId = session.getAttribute("sessionId") + "";
		
		ServletContext application = getServletContext();
		String applicationId = application.getAttribute("applicationId") + "";
		
		System.out.println("requestId : " + requestId);
		System.out.println("sessionId : " + sessionId);
		System.out.println("applicationId : " + applicationId);
		
		String myRequest = request.getParameter("myRequest");
		System.out.println("myRequest : " + myRequest);
		
		PrintWriter out = response.getWriter();
		String html = "<h1>����</h1>"
					+ "<table border='1'>"
						+ "<tr>"
							+ "<th>request</th>"
								+ "<td>" + requestId + "</td>"
//								+ "<td>" + myRequest + "</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<th>session</th>"
							+ "<td>" + sessionId + "</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<th>application</th>"
							+ "<td>" + applicationId + "</td>"
						+ "</tr>"
					+ "</table>";
		out.println(html);
		
		String test = request.getParameter("mytest");
		System.out.println("test : " + test);
		
		// request.setAttribute("myRequest", "servlet에서 보냄"); 이것은 출력된다. 왜냐하면 forward라서 그렇다. servlet이 가지고 있는 requeset와 response를 forward로 result에 위임했기 때문에 servlet의 request와 response의 값을 result가 위임받아 내부에서 사용할 수 있게 된다.
		// request와 response를 전달(forward와 include가 있다.) 어디다가? result.jsp에다가 전달한다.
		RequestDispatcher dispatch = request.getRequestDispatcher("result.jsp");
		dispatch.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

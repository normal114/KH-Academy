package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

// Web.xml 설정을 annotation으로 간략화
@WebServlet("/controller.do") // ("/") 여기 있는 패턴이 url패턴이 될 것이다. /controller.do 내용이 @WebServlet에 적용된다. 
// @WebServlet = 어노테이션, 똑같이 객체를 만든다. <servlet>도 객체를 만든다. 이름만 다를 뿐이다. 서버 안에 똑같은 타입의 서블릿이 두 개 있는 것이다. 
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	private String contextParam;
	private String initParam;
	
    /**
     * Default constructor. 
     */
    public HelloServlet() {
    	System.out.println("servlet constructor");
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet init");
		
		contextParam = config.getServletContext().getInitParameter("name");
		initParam = config.getInitParameter("sport");
		System.out.println("context-param : " + contextParam);
		System.out.println("init-param : " + initParam);
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 위 두 한글 변경 코드는 반드시 해야 한다. 엄청나게 중요하다. 
		
		System.out.println("Get 방식으로 들어옴!");
		
		// 1.
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		
		// 2. 
		// 3. 
		
		// 4.
		PrintWriter out = response.getWriter();
		out.print("<h1 style='color: red'>Hello Servlet</h1>");
		out.print("<h2>계층구조, lifecycle, url-mapping</h2>");
		out.print("<a href='home.html'>home...</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("Post 방식으로 들어옴!");
		
		// get방식으로 요청하면 get방식으로, post방식으로 요청하면 post방식으로 요청된다.
	
		// 1.
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		// 2.
		
		// 3.
		
		// 4.
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color: blue'>Hello Servlet</h1>");
		out.println("<h2>init - service - doGet/doPost - destroty</h2>");
		out.println("<a href='home.html'>home...</a>");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet destroy");
	}

}

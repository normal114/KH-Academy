<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("pageId", "my pageContext value");
	request.setAttribute("requestId", "my request value"); // controller.jsp에서 받아주는 request와 다른 얘이다.
	session.setAttribute("sessionId", "my session value");
	application.setAttribute("applicationId", "my application value");
%>
	<h1>INDEX</h1>
	
	pageId : <%=pageContext.getAttribute("pageId") %><br>
	requestId : <%=request.getAttribute("requestId") %><br>
	sessionId : <%=session.getAttribute("sessionId") %><br>
	applicationId : <%=application.getAttribute("applicationId") %><br>

	<a href="result.jsp">result</a><br>
	<!-- page이동이 이루어 지면서 request와 response 값을 가져오지 못했다. -->
	<a href="scope.do?mytest=1">test</a> <!-- forward를 위임한다. requestid는 값이 나왔다. -->
	<!-- request는 index에서 servlet에 값을 넘겨준다. -->
	<form action="scope.do" method="post">
		<input type="hidden" name="myRequest" value="my request value 2">
		<input type="submit" value="controller">
		<!-- post 방식에서는 getParameter()에 key값을 호출하였을 때 String으로 출력, 하지만 get방식은 null출력 -->
		<!-- controller는 post방식이므로 value가 출력된다. -->
	</form>
	
	<%-- <% // pageContext.forward("scope.do"); --%> // 이거 실행이 된다. 왜냐하면 자바 영역이라 <!-- --> 로 주석만 달면안되고 // 로 써야한다.

</body>
</html>
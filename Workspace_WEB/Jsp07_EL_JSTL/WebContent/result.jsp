<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=%{encoding}"); %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id = "sc" class="com.el.dto.Score" scope="session"></jsp:useBean>
	<h1><jsp:getProperty property="name" name="sc" /></h1>
	<!-- 위의 코드랑 밑의 코드는 다른 작동을 하고 있다. 해당 스코프(여기서는 session)에 sc라는 이름의 값이 있다면 담아준다. -->
	<!-- 얘는 usebean.jsp 18번 line에 이미 sc가 있는데 덮어쓰기 한 것이다. -->
	
	<h1>${sc.name }</h1>
	<!-- 얘는 위랑 상관없이 바로 session에 저장되어 있는 sc를 가져와서 사용한다. -->
	<!-- uesbean.jsp 18번 line의 코드를 바로 가져온다. -->

</body>
</html>
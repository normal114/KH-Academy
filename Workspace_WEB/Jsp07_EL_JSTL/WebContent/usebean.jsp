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
	<!-- useBean 내부를 통해 저장할 수 있다. -->
	<h1>useBean을 통한 객체 생성!</h1>
	
	<!-- Score sc = new Score(); -->
	<jsp:useBean id="sc" class="com.el.dto.Score" scope="session"></jsp:useBean>
	<!-- scope는 scope 범위를 지정해준다. -->
	<!-- jspuseBean을 가지고 객체를 생성할 수 있다. useBean을 이용해서 class를 만들 것이다. sc라는 객체 이름으로 말이다. -->
	<!-- 처음에 jsp:useBean만 만들때는 session에 sc가 없었기 때문에 sc를 임의로 만들어서 담아줬다. -->
	
	<!-- sc.setName(홍길동) -->
	<jsp:setProperty property="name" name="sc" value="홍길동"/>
	<!-- 해당 객체의 getter&setter이다. -->
	<!-- sc.getName(); -->
	<jsp:getProperty property="name" name="sc"/>

	<button onclick="location.href='result.jsp'">result</button>
	
</body>
</html>
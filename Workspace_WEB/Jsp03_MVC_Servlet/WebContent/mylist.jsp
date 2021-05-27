<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
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
<%
	List<MVCBoardDto> list = (List<MVCBoardDto>) request.getAttribute("list");
	// Object가 더 크기 때문에 형변환을 해주어야 한다.(명시적 형변환) "list"는 Object이다.
	// int타입을 byte타입으로 바꿀 수 없다. 명시적 형변환이 필요하다.
%>
<body>

	<h1>List</h1>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
<%
		for (MVCBoardDto dto : list) {
%>
		<tr>
			<td><%=dto.getSeq() %></td>
			<td><%=dto.getWriter() %></td>
			<td><a href="myservlet.do?command=selectone&seq=<%=dto.getSeq() %> "><%=dto.getTitle() %></a></td> <!--  key = value (변수이다) -->
			<td><%=dto.getRegdate() %></td>		
		</tr>
<%
		}
%>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="location.href='myservlet.do?command=insertform'" />
			</td>
		</tr>
	</table>
	
	
</body>
</html>
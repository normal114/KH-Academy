<%@page import="com.board.dto.MyBoardDto"%>
<%@page import="com.board.dao.MyBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	// request에 담겨져서 넘어온 seq 값을 int로 형 변환하자.
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(seq);
%>
<body>

	<h1>selectOne</h1>
	
	<table border="1">
		<tr>
			<th>작성자</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="목록" onclick="location.href='boardlist.jsp?seq=<%=dto.getSeq()%>'"/>
				<input type="button" value="수정" onclick="location.href='myupdate.jsp?seq=<%=dto.getSeq()%>'"/>
				<!-- 글 수정할 때 입력되어있던 글 내용을 보여줘야 한다. 따라서 ?seq=dto.getSeq() 내용을 붙인다. -->
				<input type="button" value="삭제" onclick="location.href='mydelete.jsp?seq=<%=dto.getSeq()%>'"/>
				<!-- UI / UX 는 목록, 수정, 삭제이다. 즉, 어떤 형태로 출력될 것인가?이다. -->
				<!-- 예를 들어 windows는 왼쪽이 취소 오른쪽이 확인이고, macOS는 반대이다. -->
			</td>
		</tr>
	</table>
</body>
</html>
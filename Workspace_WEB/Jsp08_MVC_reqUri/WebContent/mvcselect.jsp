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
<!-- mvcselect는 화면에다가 글 하나를 만들어 줄 것이다. -->

	<h1>SELECT</h1>
	
	<table border="1">
		<tr>
			<th>작성자</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="60" readonly="readonly">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='mvc.do?command=updateform&seq=${dto.seq} '" />
				<input type="button" value="삭제" onclick="location.href='mvc.do?command=delete&seq=${dto.seq} '" />
				<input type="button" value="목록" onclick="location.href='mvc.do?command=list'" />
			</td>
		</tr>		
	</table>
</body>
</html>
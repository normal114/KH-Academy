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

	<h1>ANSWER</h1>
	
	<form action="answerform.do" method="post">
		<input type="hidden" name="command" value="answerproc" />
		<input type="hidden" name="parentBoardNo" value="${dto.myno }" />
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myname" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle" value="RE:${dto.mytitle }" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="mycontent">${dto.mycontent }
------------------------------				
				
				</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="답변작성"/>
					<input type="button" value="취소" onclick="" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
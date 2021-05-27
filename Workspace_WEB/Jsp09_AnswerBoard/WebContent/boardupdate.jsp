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

	<jsp:useBean id="dto" class="com.answer.dto.AnswerDto" scope="request"></jsp:useBean>
	<!-- request 스코프에 있는 "dto, dto"를 통해 값을 가져와서 "id="dto"에 담아준다. 이것을 밑의 jsp:getProperty를 통해 뿌려주고 있는 것이다.  -->
	<h1>UPDATE</h1>
	
	<form action="answer.do" method="post">
		<input type="hidden" name="command" value="updateres"/>
		<input type="hidden" name="seq" value='<jsp:getProperty property="seq" name="dto"/> ' /><!-- getSeq(); 호출 -->
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><jsp:getProperty property="writer" name="dto"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value='<jsp:getProperty property="title" name="dto"/> '/></td><!-- getTitle(); 호출 -->
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="content"><jsp:getProperty property="content" name="dto" /></textarea></td><!-- getContent(); 호출 -->
			</tr>	
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정" />
					<input type="button" value="취소" onclick="" />
				</td>
		</table>
	</form>

</body>
</html>













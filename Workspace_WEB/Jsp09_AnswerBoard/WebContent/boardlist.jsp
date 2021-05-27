<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=%{encoding}"); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Answer List</h1>
	
	<table border="1">
		<col width="50px" />
		<col width="500px" />
		<col width="100px" />
		<col width="100px" />
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="4" align="center">-----작성된 글이 없습니다-----</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var= "dto">
					<tr>
						<td>${dto.boardno }</td>
						<td>
							<c:forEach begin="1" end="${dto.titletab }"> 
							<!-- 리플 달 때마다 공백을 달 것이다. 0부터 있는데 여기는 왜 1으로 지정해줬는가? titletab은 0~1인데? 0으로 넣으면 반복이 안 되기 때문이다. -->
							<!-- begin="1"은 1~1까지이고 두 번 째 답글은 1~2까지 이기 때문에 답글을 달 때 마다 공백이 늘어난다. -->
								&nbsp; <!-- 이거는 답글 앞에 띄어쓰기이다. -->
							</c:forEach>
							<a href="answer.do?command=detail&boardno=${dto.boardno }">${dto.title }</a>
						</td>
						<td>${dto.writer }</td>
						<td>${dto.regdate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="answer.do?command=boardinsert" />
			</td>
		</tr>
	</table>
	
</body>
</html>
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

	<h1>EL</h1>

	<table border="1">
		<tr>
			<th colspan="2">${score.name } 님의 점수표</th>
			<!--              aa.name이란 얘를 넣으면 홍길동을 읽어오지 못하기 떄문에 null이라서 exception이 떠야 하는데 그냥 없던 일로 해서 그 부분이 출력되지 않는다. -->
		</tr>
		<tr>
			<th>국어</th>
			<td>${score.kor }</td>
		</tr>
		<tr>
			<th>영어</th>
			<td>${score.eng }</td>
		</tr>
		<tr>
			<th>수학</th>
			<td>${score.math }</td>
		</tr>
		<tr>
			<th>총점</th>
			<td>${score.sum }</td>
		</tr>
		<tr>
			<th>평균</th>
			<td>${score.avg }</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${score.grade }</td>
		</tr>
	</table>

</body>
</html>
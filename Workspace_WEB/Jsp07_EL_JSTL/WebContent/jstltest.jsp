<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=%{encoding}"); %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL : Jsp Standard Tag Library</h1>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등급</th>
		</tr>
		<c:forEach items="${list }" var="score"> <!-- arqument가 있다. var에는 변수명(아무거나) item에는 scope에 있는 얘 -->
			<tr>
				<td>
					<!-- eq: == / ne : != / empty : null -->
					<c:if test="${score.name eq '이름10' } "> <!-- eq는 equal같다. 10번째 이름이면  홍길동 -->
						<c:out value="홍길동"></c:out>
					</c:if>
					<c:choose>
						<c:when test="${score.name eq '이름20' }"> <!-- 이름이 10씩 커지니까 2번째 이름이다. -->
							<c:out value="${score.name}님!"></c:out>
						</c:when>
						<c:when test="${score.name eq '이름30' }">
							<c:out value="${score.name }"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="누구지?"></c:out>
						</c:otherwise>
					</c:choose>
				</td>
				<td>${score.kor }</td>
				<td>${score.eng }</td>
				<td>${score.math }</td>
				<td>${score.sum }</td>
				<td>${score.avg }</td>
				<td>
					<c:choose>
						<c:when test="${score.grade eq 'A' || score.grade eq 'B' }">
							<c:out value="PASS"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="FAIL"></c:out>
						</c:otherwise>
					</c:choose>
				</td>
			</c:forEach>
		</table>
		
		<C:forEach var="i" begin="1" end="10" step="1">
			${i }<br/>
		</C:forEach>
		
		<c:forEach var="i" begin="1" end="20" step="2">
			${i }<br/>
		</c:forEach>
		
		<!-- 구구단 출력 -->
		
</body>
</html>
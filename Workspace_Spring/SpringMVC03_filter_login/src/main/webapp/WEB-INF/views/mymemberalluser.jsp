<%@page import="com.mvc.upgrade.model.dto.MYMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<input type="hidden" name="myno" value="${dto.memberno }">
	<table border="1">
		<col width="100">
		<col width="100">
		<col width="300">
		<tr>
			<th>아이디</th>
			<td>${dto.memberid }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${dto.membername }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${dto.memberaddr }
			<td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${dto.memberphone }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${dto.memberemail }</td>
		</tr>
		<tr>
			<th>회원등급</th>
			<td>${dto.memberrole }</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit"
				value="내 정보 수정"></td>
		</tr>

	</table>
</body>
</html>
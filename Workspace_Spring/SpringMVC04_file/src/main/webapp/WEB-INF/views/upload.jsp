<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		<h3>uploadForm</h3>
		file<br/>
		<input type="file" name="mpfile" /><br />
		<p style="color:red; font-weight: bold;">
			<form:errors path="mpfile"></form:errors>
		</p><br/>
		<textarea rows="10" cols="40" name="desc"></textarea><br/>
		<input type="submit" value="send" /> <!-- submit를 클릭하면 dto에 담겨서 controller의 /upload로 간다. -->
	</form:form>
	
	<!-- 
	enctype
	1. application/www-form-urlencoded ; (default) 문자들을 encoding
	2. multipart/form-data : file upload -> post 
	3. text/plain : encoding 하지 않음
	
	spring form tag
		form:form, form:errors, form:input...
		태그를 집어넣으면 자바 주석이라 에러가 난다.
		form:error - Errors, BindingResult를 사용할 떄, command 객체의 특정 field에서 발생하는 에러메시 출력
		
	 -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function idCheckProc(){
		var chk = document.getElementsByName("memberid")[0].title;
		if(chk == 'n'){
			alert("id 중복체크를 해주세요!");
			document.getElementsByName("memberid")[0].focus();
		}
	}
	
	function idCheck(){
		var memberid = document.getElementsByName("memberid")[0].value;
		
		if( memberid == null || memberid.trim() == ""){
			alert("id를 입력해 주세요!");
		} else {
			open("registres.do?idchk&memberid="+memberid, "", "width=200, height=200");
		}
	}

</script>
</head>
<body>
	
	<h1>회원가입</h1>
	
	<form action="registres.do" method="post">		
		<table border="1">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="memberid" required="required" title="n">
					<input type="button" value="종복체크" onclick="idCheck();">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="memberpw" required="required" onclick="idCheckProc();"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="membername" required="required" onclick="idCheckProc()"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="memberaddr" required="required" onclick="idCheckProc()"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="memberphone" required="required" onclick="idCheckProc()"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="memberemail" required="required" onclick="idCheckProc()"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="가입">
					<input type="button" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
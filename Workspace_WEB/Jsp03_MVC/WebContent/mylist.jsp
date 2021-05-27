<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=%{encoding}");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$("#muldelform").submit(function() {
			// 유효성 검사
			if ($("#muldelform input:checked").length == 0) {
				alert("하나 이상 체크해 주세요");
				return false;
			}
		});

		$("input[name=chk]")
				.click(
						function() {
							if ($("input[name=chk]").length == $("input[name=chk]:checked").length) {
								$("input[name=all]").prop("checked", true);
							} else {
								$("input[name=all]").prop("checked", false);
							}
						});

	});

	function allchk(bool) {
		var chks = document.getElementsByName("chk");
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked = bool;
		}
	}
</script>
<%
	List<MVCBoardDto> list = (List<MVCBoardDto>) request.getAttribute("list");
// Object가 더 크기 때문에 형변환을 해주어야 한다.(명시적 형변환) "list"는 Object이다.
// int타입을 byte타입으로 바꿀 수 없다. 명시적 형변환이 필요하다.
%>
<body>

	<h1>List</h1>
	<form action="mycontroller.jsp" method="post">
		<input type="hidden" name="command" value="multidelete">
		<table border="1">
			<tr>
				<th><input type="checkbox" name="all"
					onclick=allchk(this.checked);></th>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<%
				for (MVCBoardDto dto : list) {
			%>
			<tr>
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq()%>"></td>
				<td><%=dto.getSeq()%></td>
				<td><%=dto.getWriter()%></td>
				<td><a
					href="mycontroller.jsp?command=selectone&seq=<%=dto.getSeq()%> "><%=dto.getTitle()%></a></td>
				<!--  key = value (변수이다) -->
				<td><%=dto.getRegdate()%></td>
			</tr>
			<%}%>
			<tr>
				<td colspan="5" align="right"><input type="button" value="글작성"
					onclick="location.href='mycontroller.jsp?command=insertform'" /> <input
					type="submit" value="선택삭제"></td>
			</tr>
		</table>
	</form>

</body>
</html>
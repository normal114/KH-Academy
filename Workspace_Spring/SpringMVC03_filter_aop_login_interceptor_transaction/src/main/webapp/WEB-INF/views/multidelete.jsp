<%@page import="com.mvc.upgrade.model.biz.MYBoardBizImpl" %>
<%@page import="com.mvc.upgrade.model.biz.MYBoardBiz" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String[] mynoes = request.getParameterValues("chk");

	if (mynoes == null || mynoes.length == 0) {
%>
	<script type="text/javascript">
		alert("하나 이상 체크해주세요!");
		location.href="list.do";
	</script>
<%
	} else {

		MYBoardBiz biz = new MYBoardBizImpl();
		int res = biz.multiDelete(mynoes);
		if (res > 0) {
%>
	<script type="text/javascript">
		alert("체크된 글들을 삭제 성공하였습니다.");
		location.href="list.do";
	</script>
<%
		} else{
%>
	<script type="text/javascript">
		alert("체크된 글들을 삭제 실패하였습니다.");
		location.href="list.do";
	</script>
<%
		}
	}
%>

</body>
</html>
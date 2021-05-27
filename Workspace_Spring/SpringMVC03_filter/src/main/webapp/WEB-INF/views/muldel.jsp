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
	String[] seqs = request.getParameterValues("chk"); // allon&chk=value,chk=value 이렇게 넘어오면 배열로 응답줄 것이다. 이것이 getParameterValues이다.

	if (seqs == null || seqs.length == 0) {
%>
	<script type="text/javascript">
		alert("하나 이상 체크해주세요!");
		location.href="boardlist.jsp";
	</script>
<%
	} else {

		MYBoardBiz biz = new MYBoardBizImpl();
		int res = biz.multiDelete(seqs);
		if (res > 0) {
%>
	<script type="text/javascript">
		alert("체크된 글들을 삭제 성공하였습니다.");
		location.href="boardlist.jsp";
	</script>
<%
		} else{
%>
	<script type="text/javascript">
		alert("체크된 글들을 삭제 실패하였습니다.");
		location.href="boardlist.jsp";
	</script>
<%
		}
	}
%>

</body>
</html>
<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// chk=1&chk2 ... 같은 이름으로 여러 개의 값이 전달되고 있을 때 사용
	String[] seqs = request.getParameterValues("chk");

	if(seqs == null || seqs.length == 0){
%>
	<script type="text/javascript">
		alert("삭제할 글을 선택해 주세요!");
		location.href="boardlist.jsp";
	</script>
<%
	} else {
		MDBoardBiz biz = new MDBoardBizImpl();
		int res = biz.multiDelete(seqs);
		if(res > 0){
%>
		<script type="text/javascript">
			alert("선택한 게시글들을 삭제하였습니다");
			location.href="boardlist.jsp";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("여러 글들을 삭제하지 못하였습니다.");
			location.href="boardlist.jsp";
		</script>
<%
		}
	}
%>

</body>
</html>
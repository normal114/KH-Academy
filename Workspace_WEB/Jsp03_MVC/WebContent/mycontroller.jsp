<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
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
<body>

	<%
		String command = request.getParameter("command");
	System.out.printf("[%s]\n", command);

	MVCBoardBiz biz = new MVCBoardBizImpl();

	// 요청한 명령을 확인한다.
	if (command.equals("list")) {
		// 1. 보내준 값이 있으면, 받는다.

		// 2. db에 전달할 값이 있으면 전달하고,
		//	  없으면 없는대로 호출해서 리턴받는다.
		List<MVCBoardDto> list = biz.selectList();

		// 3. 화면에 전달할 값이 있으면, request 객체에 담아준다.
		request.setAttribute("list", list);
		// list라는 객체를 "list"라는 이름으로 담았다. Object타입으로 감싸서 담는다. 그리고 mylis로 보낸다.

		// 4. 보낸다.
		pageContext.forward("mylist.jsp"); // request에 뭐 담았을 때 forward

	} else if (command.equals("insertform")) {
		// 1.
		// 2.
		// 3.
		// 4.
		response.sendRedirect("myinsert.jsp"); // 안 담겼으면 sendRedirect
		/*
			pageContext.foward() : 페이지 위임 (request, response 객체가 그대로 전달)
			response.sendRedirect() : 페이지 이동 (새로운 request, response 객체)
		*/
		// 값을 저장해서 보내고 싶으면 foword()로 만든다.
		// 페이지 이동한 하고 싶으면 sendRedirect()로 만든다.

	} else if (command.equals("insertres")) {
		// 1.
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 2.
		MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
		int res = biz.insert(dto);
		// 3.

		// 4.
		if (res > 0) {
	%>
	<script type="text/javascript">
		alert("글 작성 성공");
		location.href='mycontroller.jsp?command=list';
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("글 작성 실패");
		location.href='mycontroller.jps?command=insertform';
	</script>
	<%
		}
	} else if (command.equals("selectone")) {
	// 1.
	int seq = Integer.parseInt(request.getParameter("seq")); // queryString에 있는 selectone&seq의 seq를 가져온 것이다. 
	// 2. 
	MVCBoardDto dto = biz.selectOne(seq);
	// 3.
	request.setAttribute("dto", dto);
	// 4.
	pageContext.forward("myselect.jsp");

	} else if (command.equals("updateform")) {
	// 1.
	int seq = Integer.parseInt(request.getParameter("seq"));
	// 2.
	MVCBoardDto dto = biz.selectOne(seq);
	// 3.
	request.setAttribute("dto", dto);
	// 4.
	pageContext.forward("myupdate.jsp");

	} else if (command.equals("updateres")) {
	// 1.
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	// 2.
	MVCBoardDto dto = new MVCBoardDto();
	dto.setSeq(seq);
	dto.setTitle(title);
	dto.setContent(content);
	int res = biz.update(dto);
	// 3. 없음
	// 4.
	if (res > 0) {
	%>
	<script type="text/javascript">
			alert("수정 성공");
			location.href="mycontroller.jsp?command=selectone&seq=<%=seq%>";
		</script>

	<%
		} else {
	%>
	<script type="text/javascript">
			alert("수정 실패");
			history.back(); // 뒤로가기, 다음 시간에 배울 로그인 만들기 때는 못 쓴다.
		</script>
	<%
		}
	} else if (command.equals("delete")) {
	// 1.
	int seq = Integer.parseInt(request.getParameter("seq"));
	// 2.
	int res = biz.delete(seq);
	// 3.
	// 4.
	if (res > 0) {
	%>
	<script type="text/javascript">
			alert("삭제 성공");
			location.href="mycontroller.jsp?command=list";
		</script>
	<%
		} else {
	%>
	<script type="text/javascript">
			alert("삭제 실패");
			location.href="mycontroller.jsp?command=selectone&seq=<%=seq%>
		";
	</script>
	<%
		}

	} else if (command.equals("multidelete")) {
	String[] seqs = request.getParameterValues("chk");

	if (seqs == null || seqs.length == 0) {
	%>
	<script type="text/javascript">
		alert("삭제할 글을 선택해 주세요!");
		location.href = "mycontroller.jsp?command=list";
	</script>
	<%
		} else {
	int res = biz.multiDelete(seqs);
	if (res > 0) {
	%>
	<script type="text/javascript">
		alert("선택한 게시글들을 삭제하였습니다");
		location.href = "mycontroller.jsp?command=list";
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("선택한 글들을 삭제하지 못하였습니다.");
		location.href = "mycontroller.jsp?command=list";
	</script>
	<%
		}
	}
	}
	%>

</body>
</html>
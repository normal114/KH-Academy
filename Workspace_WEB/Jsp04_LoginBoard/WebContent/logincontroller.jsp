<%@page import="java.util.List"%>
<%@page import="com.login.dto.MYMemberDto"%>
<%@page import="com.login.biz.MYMemberBiz"%>
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

<%
	String command = request.getParameter("command");
	System.out.println("[" + command + "]");
	
	MYMemberBiz biz = new MYMemberBiz();
	
	if (command.equals("login")) {
		
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		MYMemberDto dto = biz.login(myid, mypw); // index에서 myid, mypw 입력하면 여기서 받아서 dao -> biz 이런 순으로 전달하게 된다. 
		
		if (dto != null){
		// if (dto.getMyid() != null){ // new MYMemberDto();로 써놓으면 무조건 값이 들어가서 성공이 뜬다.
			// session scope에 객체 담기, 로그인 되었을 때 session이라는 얘에 담아둔다.
			// 왜 session에 담느냐? request는 한 번 사용되면 없어진다. 하지만 session은 만료되기 전까지 계속 사용할 수 있다.
			session.setAttribute("dto", dto);
			// 만료되는 시간 설정 (default: 30분)
			session.setMaxInactiveInterval(10 * 60);
			
			if (dto.getMyrole().equals("ADMIN")) {
				response.sendRedirect("adminmain.jsp"); // request는 한 번 사용하면 없어지기 때문에 sendRedirect를 사용할 수 없다. 
			} else if (dto.getMyrole().equals("USER")) {
				response.sendRedirect("usermain.jsp");
			}
			
		} else {
%>
		<script type="text/javascript">
			alert("로그인 실패");
			location.href="index.html";
		</script>
<%
		}
	} else if (command.equals("logout")) { // logout하면 session의 값을 없애버린다.
		// session scope에서 값 삭제 (만료)
		session.invalidate();
		response.sendRedirect("index.html");
	
	} else if (command.equals("listall")) {
		// 1. 없다.
		// 2. 
		List<MYMemberDto> list = biz.selectAllUser();
		// 3. 객체 담기
		request.setAttribute("list", list);
		pageContext.forward("userlistall.jsp");
	
	} else if (command.equals("listen")) {
		// 1. 없다.
		// 2.
		List<MYMemberDto> list = biz.selectEnabledUser();
		// 3. 객체 담기
		request.setAttribute("list", list);
		// 4.
		pageContext.forward("userlisten.jsp");
		
	} else if (command.equals("updateroleform")) {
		// 1.
		int myno = Integer.parseInt(request.getParameter("myno"));
		// 2.
		MYMemberDto dto = biz.selectUser(myno);
		// 3.
		request.setAttribute("dto", dto);
		// 4.
		pageContext.forward("updaterole.jsp");
		
	} else if (command.equals("updaterole")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		
		int res = biz.updateRole(myno, myrole);
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("등급 변경 성공");
			location.href="logincontroller.jsp?command=listen";
		</script>
<%
		} else {
%>
			<script type="text/javascript">
				alert("등급 변경 실패");
				location.href="logincontroller.jsp?command=updateroleform&myno=<%=myno%>";
			</script>
<%		
		}
		
	} else if (command.equals("registform")) {
		response.sendRedirect("regist.jsp");
		
	} else if (command.equals("idchk")) {
		String myid = request.getParameter("myid");
		MYMemberDto dto = biz.idCheck(myid);
		boolean idnotused = true;
		
		if (dto.getMyid() != null) {
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
			
		}
	
%>





























	<h1 style="color: red;">잘못왔다...</h1>

</body>
</html>
<%@page import="java.util.Calendar"%>
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
	int year = Integer.parseInt(request.getParameter("year"));
	int month = Integer.parseInt(request.getParameter("month"));
	int date = Integer.parseInt(request.getParameter("date"));
	int lastDay = Integer.parseInt(request.getParameter("lastDay"));

	Calendar cal = Calendar.getInstance();
	int hour = cal.get(Calendar.HOUR_OF_DAY);
	int min = cal.get(Calendar.MINUTE);
%>

	<h1>일정 작성</h1>

	<form action="cal.do" method="post">
		<input type="hidden" name="command" value="insert"/>
		
		<table border="1"> <!-- 연필 그림을 클릭했을 시 id, 일정이 나오고 년도는 셀렉트 할 수 있게 만들었다. -->
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" value="kh" readonly="readonly" /></td> <!-- 만약에 회원가입 만들면 세션 부분을 넣어도 된다. -->
			</tr>
			<tr>
				<th>일정</th>
				<td>
				<select name="year">
<%					
					for (int i = year-5; i<year+6; i++) { // 셀렉트를 현재 연도를 기준으로 -5년 까지 나오고 +6년(실제 5년)까지 나오게 만들었다.				
%>				
							<option value="<%=i%>" <%=(year==i)?"selected":"" %> ><%=i %></option>
<%
					}
%>				
				</select>년
				<select name="month">
<%
				for (int i = 1; i < 13; i++) { // 12월까지
%>
					<option value="<%=i%>"<%=(month==i)? "selected": "" %> ><%=i %></option>
<%
				}
%>
				</select>월
				<select name="date">
<%
				for(int i = 1; i<=lastDay; i++) { // 28, 30, 31일까지
%>
					<option value="<%=i%>" <%=(date==i)? "seleted": "" %> ><%=i %></option>
<%
				}
%>
				</select>일
				<select name="hour">
<% 
				for (int i = 0; i < 24; i++) {
%>
					<option value="<%=i %>" <%=(hour == i)? "selected": "" %> ><%=i %></option>					
<%
				}
%>
				</select>시				
				<select name="min">
<%
				for (int i = 0; i < 60; i++) {
%>
					<option value="<%=i%>" <%=(min == i)? "selected": "" %> ><%=i %></option>
<%				
				}
%>
				</select>분
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"/></td>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="일정작성" />
					<input type="button" value="취소" onclick="location.href='calendar.jsp'" />
				</td>
			</tr>
		</table>
	</form>



</body>
</html>
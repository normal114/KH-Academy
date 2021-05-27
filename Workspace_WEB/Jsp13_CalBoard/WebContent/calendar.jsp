<%@page import="com.cal.dto.CalDto"%>
<%@page import="java.util.List"%>
<%@page import="com.cal.dao.CalDao"%>
<%@page import="com.cal.common.Util"%>
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

<style type="text/css">

	#calendar {
		border-collapse: collapse;
		border: 1px solid gray;
	}
	#calendar th {
		width: 80px;
		border: 1px solid gray;
	}
	#calendar td {
		width: 80px;
		height: 80px;
		border: 1px solid gray;
		text-align: left;
		vertical-align: top;
		position: relative;
	}
	a{
		text-decoration: none; <!-- _삭제 -->
	}
	
	.list > p {
		font-size: 5px; <!-- 글자크기 -->
		margin: 1px;
		background-color: skyblue;
	}
	
	.preview {
		position: absolute;
		top: -30px;
		left: 10px;
		background-color: skyblue;
		width: 40px;
		height: 40px;
		text-align: center;
		line-height: 40px;
		border-radius: 40px 40px 40px 1px;
	}

</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	function isTwo(n){
		return (n.length<2)?"0"+n : n;
	}
	
	$(function(){
		$(".countview").hover(function(){
			// handle in
			var countView = $(this);
			var year = $(".y").text().trim();
			var month = $(".m").text().trim();
			var date = countView.text().trim();
			var yyyyMMdd = year + isTwo(month) + isTwo(date);
			
			$.ajax({
				type: "post",
				url: "count.do?id=kh&yyyyMMdd="+yyyyMMdd,
				dataType: "json",
				async: false, // 동기방식, 데이터를 전부 수신 받고 다음단계 진행
				success: function(msg){
					var count = msg.calcount;
					countView.after("<div class='preview'>" + count + "</div>");
				},
				error: function(){
					alert("통신 실패");
				}
			});
	
		},
		function(){
			// handle out	
			$(".preview").remove();
		});
	});



</script>

</head>
<body>
<%
	Calendar cal = Calendar.getInstance(); // 추상클래스 Calendar를 import해서 instance를 호출한다.
	
	int year = cal.get(Calendar.YEAR); // 상수값 반환
	int month = cal.get(Calendar.MONTH) + 1; // 얘네가 month은 index가 0으로 시작해서 +1 하도록 만들었다.
	
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");
	if (paramYear != null) {
		year = Integer.parseInt(paramYear); // String이니 int로
	}
	if (paramMonth != null) {
		month = Integer.parseInt(paramMonth);
	}
	
	if (month > 12) { // 12월이 넘어가면
		month = 1; // 내년 1월로 바꾸고
		year++; // 1년을 더한다.
	}
	if (month < 1) { // 1월보다 아래면
		month = 12; // 전년도 12월로 바꾸고
		year--; // 1년을 뺸다.
	}

	cal.set(year, month-1, 1); // 전년도까지 계산한다.
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일 계산기. 오늘 날짜
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 마지막 일

	
	CalDao dao = new CalDao();
	String yyyyMM = year + Util.isTwo(String.valueOf(month));
	List<CalDto> list = dao.getCalViewList("kh", yyyyMM);
	
	

%>

	<table id="calendar">
		<caption>
			<a href="calendar.jsp?year=<%=year-1%>&month=<%=month%>">◁</a> <!-- 1년 뺴기 -->
			<a href="calendar.jsp?year=<%=year%>&month=<%=month-1%>">◀</a> <!-- 1달 빼기 -->
	
			<span class="y"><%=year %></span>년
			<span class="m"><%=month %></span>월
			
			<a href="calendar.jsp?year=<%=year%>&month=<%=month+1%>">▶</a> <!-- 1달 추가 -->
			<a href="calendar.jsp?year=<%=year+1%>&month=<%=month%>">▷</a> <!-- 1년 추가 -->
		</caption>
		
		<tr style="background-color:yellow">
			<th style="color:red">일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th style="color:blue">토</th>
		</tr>
		
		<tr>
<%
		for (int i = 0; i < dayOfWeek-1; i++) { // 내가 입력한 주의 요일
			out.print("<td></td>");
		}
		for (int i = 1; i <= lastDay; i++) { // 마지막 날짜
%>
			<td>
				<a class="countview" href="cal.do?command=list&year=<%=year %>&month=<%=month %>&date=<%=i %>" style="color: <%=Util.fontColor(i, dayOfWeek)%>"><%=i %></a> <!-- 숫자나오는 부분, 색상을 입힌다.-->
				
				<a href="insert.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastDay=<%=lastDay%>"> <!-- 숫자 누르면 insert.jsp로 간다. -->
					<img alt="" src="image/pen.png" style="width: 10px; height: 10px;" /> <!-- 숫자 옆에 pen.png 호출한다. -->
				</a>
				<div class="list">
					<%=Util.getCalView(i, list) %>				
				</div>
			</td>
<%
			if ((dayOfWeek-1+i)%7 == 0){ // 7로 떨어진다면
				out.print("</tr><tr>");
			}
		}
		
		for (int i = 0; i < (7-(dayOfWeek - 1 + lastDay)%7)%7; i++) { // 남는 마지막 칸까지 출력 
			out.print("<td></td>");
		}
%>		
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="myboard.css" />
<title>Insert title here</title>
<style>

* {
	margin: 0;
	padding: 0;
}

.main02 {
	padding-top: 60px;
}

.board {
	margin: 0 260px;
}

caption {
	display: none;
}

a {
	text-decoration: none;
}

.board_list_wrap {
	padding: 50px;
}

.board_list {
	width: 100%;
	border-top: 1px solid OrangeRed;
}

.board_list tr {
	border-bottom: 1px solid #ccc;
}

.board_list th, .board_list td {
	padding: 10px;
	font-size: 14px;
}

.board_list td {
	text-align: center;
}

.board_list tbody tr td:nth-child(3) {
	text-align: left;
}

.board_list .tit:hover {
	text-decoration: underline;
}

.board_list_wrap .paging {
	margin-top: 20px;
	text-align: center;
	font-size: 0;
}

.board_list_wrap .paging a {
	display: inline-block;
	margin-left: 10px;
	padding: 5px 10px;
	border: 1px solid OrangeRed;
	border-radius: 100px;
	font-size: 14px;
}

.board_list_wrap .paging a:first-child {
	margin-left: 0;
}

.board_list_wrap .paging a.bt {
	border: 1px solid #eee;
	background: #eee;
}

.board_list_wrap .paging a.num {
	border: 1px solid OrangeRed;
	font-weight: 600;
	color: OrangeRed;
}

.board_list_wrap .paging a.num.on {
	background: OrangeRed;
	color: #fff;
}

.bt_wrap a {
	display: inline-block;
	min-width: 80px;
	margin-left: 10px;
	padding: 8px;
	border: 1px solid OrangeRed;
	border-radius: 2px;
	font-size: 14px;
}

.bt_wrap a.on {
	background: OrangeRed;
	color: white;
	border-radius: 100px;
}

.bt_wrap a.on:hover {
	background: OrangeRed;
	color: white;
	border-radius: 100px;
	text-decoration: underline white;
}

.bt_wrap a.off {
	color: OrangeRed;
	border-radius: 100px;
}

.bt_wrap a.off:hover {
	color: OrangeRed;
	border-radius: 100px;
	text-decoration: underline OrangeRed;
}

div .pagemove {
	width: 30px;
	height: 30px;
	border: 1px solid OrangeRed;
	border-radius: 100%;
	color: OrangeRed;
}

div .pagemove:hover {
	width: 30px;
	height: 30px;
	border: 1px solid lightgray;
	border-radius: 100%;
	background-color: lightgray;
	color: white;
}

.paging {
	margin-top: 40px;
	margin-bottom: 50px;
	text-align: center;
	font-size: 0;
}

.paging a {
	display: inline-block;
	margin-left: 10px;
	padding: 5px 10px;
	border: 1px solid teal;
	border-radius: 100px;
	font-size: 14px;
}

#paging {
	border: none;
	background-Color: #F5F5F5;
	font: 18px;
	border-radius: 100px;
	color: black;
	width: 86px;
	height: 32px;
	cursor: pointer;
}

#paging:hover {
	border: none;
	background-Color: lightgray;
	font: 18px;
	border-radius: 100px;
	color: black;
	width: 86px;
	height: 32px;
	cursor: pointer;
}

.pagination {
	padding: 0 0;
	text-align: center;
}

.pagination a {
	padding: 3px 8px;
	margin: 5px;
	cursor: pointer;
}

.pagination a.on {
	width: 30px;
	height: 30px;
	border: 1px solid OrangeRed;
	border-radius: 100%;
	background-color: OrangeRed;
	color: white;
}

#mpage01 {
	border: none;
	background-Color: OrangeRed;
	border: 1px solid white;
	font-size: 14px;
	border-radius: 100px;
	color: white;
	width: 86px;
	height: 32px;
	cursor: pointer;
	vertical-align: 4px;
}

#mpage01:hover {
	border: none;
	background-Color: OrangeRed;
	border: 1px solid white;
	font-size: 14px;
	border-radius: 100px;
	text-decoration: underline white;
	color: white;
	width: 86px;
	height: 32px;
	cursor: pointer;
	vertical-align: 4px;
}

.individual01 {
	margin-top: 20px;
	text-align: right;
}
</style>
</head>
<body>

	<div class="main02" style="text-align: center">
		<div style="font-size: 40px; font-weight: bold">INSERT</div>
	</div>

	<div class="board">
		<div class="board_list_wrap">
			<table class="board_list">
				<caption>게시판 목록</caption>
				<thead>
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>제목</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty list }">
							<tr>
								<th colspan="4">----------작성된 글이 없습니다----------</th>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${list }" var="dto">
								<tr>
									<td>${dto.myno }</td>
									<td>${dto.myname }</td>
									<td><a href="detail.do?myno=${dto.myno }">${dto.mytitle }</a></td>
									<td>${dto.mydate }</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<div class="individual01">
				<input type="button" id="mpage01" value="글작성"
					onclick="location.href='writeform.do'">
			</div>
		</div>
	</div>
</body>
</html>
<%@page import="com.mvc.upgrade.model.dao.MYBoardDaoImpl"%>
<%@page import="com.mvc.upgrade.model.dao.MYBoardDao"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.upgrade.model.dto.MYBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/myboard01.css" />
</head>

<body>

	<div class="main02" style="text-align: center">
		<div style="font-size: 40px; font-weight: bold">게시판 목록</div>
	</div>

	<div class="board">
		<div class="board_list_wrap">
			<table class="board_list">
				<caption>게시판 목록</caption>
				<thead>
					<tr>
						<th class="num">번호</th>
						<th class="writer">작성자</th>
						<th class="title">제목</th>
						<th class="regdate">작성일</th>
						<th class="viewcnt">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty list }">
							<tr style="border-bottom: 1px solid #ccc">
								<th colspan="4">----------작성된 글이 없습니다----------</th>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${list }" var="dto">
								<tr>
									<td>${dto.myno }</td>
									<td>${dto.myname }</td>
									<td><c:choose>
											<c:when test="${dto.delflag eq 'Y' }">
												<c:out value="----------삭제된 글 입니다----------">
												</c:out>
											</c:when>
											<c:otherwise>
												<c:forEach begin="1" end="${dto.titletab }">
													&nbsp;
												</c:forEach>
												<a href="detail.do?myno=${dto.myno }">${dto.mytitle }</a>
											</c:otherwise>
										</c:choose></td>
									<td><fmt:formatDate value="${dto.mydate }"
											pattern="yyyy년 MM월 dd일" /></td>
									<td>${dto.viewCnt }</td>
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
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

<script type="text/javascript"
	src="http://code.jquery.com/jquery-lastest.js"></script>

<script type="text/javascript">
	
</script>
</head>
<body>

	<div class="main02" style="text-align: center">
		<div style="font-size: 40px; font-weight: bold">게시판 목록</div>
	</div>

	<div class="board">
		<div class="board_list_wrap">
			<form action="muldel.do" method="post" id="muldelform"></form>
			<table class="board_list">
				<caption>게시판 목록</caption>
				<thead>
					<tr>
						<th class="box"><input type="checkbox" name="all"
							onclick="allCheck(this.checked);" /></th>
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
									<th><input type="checkbox" name="chk"
										value="${dto.getMyno() }" /></th>
									<td>${dto.myno }</td>
									<td>${dto.myname }</td>
									<td><a href="detail.do?myno=${dto.myno }">${dto.mytitle }</a></td>
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
					onclick="location.href='writeform.do'"> <input
					type="submit" id="mpage02" value="선택삭제" />

			</div>
		</div>
	</div>

	<ul class="btn-group pagination">
		<c:if test="${pageMaker.prev }">
			<li><a
				href='<c:url value="/board/boardList?page=${pageMaker.startPage-1 }"/>'><i
					class="fa fa-chevron-left"></i></a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }"
			var="pageNum">
			<li><a href='<c:url value="/board/boardList?page=${pageNum }"/>'><i
					class="fa">${pageNum }</i></a></li>
		</c:forEach>
		<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
			<li><a
				href='<c:url value="/board/boardList?page=${pageMaker.endPage+1 }"/>'><i
					class="fa fa-chevron-right"></i></a></li>
		</c:if>
	</ul>

</body>
</html>
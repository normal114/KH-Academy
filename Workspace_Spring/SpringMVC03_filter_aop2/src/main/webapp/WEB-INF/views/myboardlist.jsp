<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
	function allCheck(bool) {
		var chks = document.getElementsByName("chk");
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked = bool;
		}
	}

	$(function() {
		$("#muldelform").submit(function() {
			if ($("#muldelform input:checked").length == 0) {
				alert("하나 이상 체크해 주세요");

				return false;
			}
		});
	});
</script>

<link rel="stylesheet" type="text/css" href="./css/myboard01.css" />
</head>

<body>

	<div class="main02" style="text-align: center">
		<div style="font-size: 40px; font-weight: bold">게시판 목록</div>
	</div>

	<div class="board">
		<div class="board_list_wrap">
			<form action="./muldel.jsp" method="post" id="muldelform"></form>
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
					onclick="location.href='writeform.do'"> <input
					type="submit" id="mpage02" value="선택삭제" />
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/myboard02.css" />
<title>Insert title here</title>
</head>
<body>

	<div class="main02" style="text-align: center">
		<div style="font-size: 40px; font-weight: bold">글 상세 보기</div>
	</div>

	<div class="board">
		<div class="board_list_wrap">
			<section id="myboard_insert">
				<table class="board_list">
					<caption>게시판 상세보기</caption>
					<thead>
						<tr>
							<th>작성자</th>
							<td>${dto.myname }</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>${dto.mytitle }</td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea class="noresize" rows="25" cols="70"
									readonly="readonly">${dto.mycontent }</textarea></td>
						</tr>
					</thead>
				</table>
			</section>
			<div class="individual01">
				<input type="button" id="mpage01" value="답변" onclick="location.href='answer.do?myno=${dto.myno }'" />
				<input type="button" id="mpage01" value="수정"
					onclick="location.href='updateform.do?myno=${dto.myno }'" /> <input
					type="button" id="mpage01" value="삭제"
					onclick="location.href='delete.do?myno=${dto.myno }'" /> <input
					type="button" id="mpage02" value="목록"
					onclick="location.href='list.do'" />
			</div>
		</div>
	</div>
</body>
</html>
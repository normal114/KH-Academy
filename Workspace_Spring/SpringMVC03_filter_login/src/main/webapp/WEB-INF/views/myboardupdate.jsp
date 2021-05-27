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
		<div style="font-size: 40px; font-weight: bold">글 수정 하기</div>
	</div>

	<div class="board">
		<div class="board_list_wrap">
			<section id="myboard_update">
				<form action="updateres.do" method="post">
					<input type="hidden" name="myno" value="${dto.myno }" />
					<table class="board_list">
						<caption>글수정 하기</caption>
						<thead>
							<tr>
								<th>작성자</th>
								<td>${dto.myname }</td>
							</tr>
							<tr>
								<th>제목</th>
								<td><input type="text" name="mytitle"
									placeholder="제목을 입력하세요" value="${dto.mytitle }" /></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea rows="25" cols="70" class="noresize"
										name="mycontent" placeholder="내용을 입력하세요">${dto.mycontent }</textarea></td>
							</tr>
						</thead>
					</table>
					<div class="individual01">
						<input type="submit" id="mpage01" value="글수정" /> <input
							type="button" id="mpage02" value="취소"
							onclick="location.href='detail.do?myno=${dto.myno }'" />
					</div>
				</form>
			</section>
		</div>
	</div>

</body>
</html>
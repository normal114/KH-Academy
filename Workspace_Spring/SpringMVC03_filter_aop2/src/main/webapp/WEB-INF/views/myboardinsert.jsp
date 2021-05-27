<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/myboard02.css" />
</head>
<body>

	<div class="main02" style="text-align: center">
		<div style="font-size: 40px; font-weight: bold">글 작성 하기</div>
	</div>

	<div class="board">
		<div class="board_list_wrap">
			<section id="myboard_insert">
				<form action="writeres.do" method="post">
					<table class="board_list">
						<caption>게시판 글작성</caption>
						<thead>
							<tr>
								<th>작성자</th>
								<td><input type="text" name="myname"
									placeholder="이름을 작성하세요" /></td>
							</tr>
							<tr>
								<th>제목</th>
								<td><input type="text" name="mytitle"
									placeholder="제목을 작성하세요" /></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea class="noresize" rows="25" cols="70"
										name="mycontent" placeholder="내용을 작성하세요"></textarea></td>
							</tr>
					</table>
					<div class="individual01">
						<input type="submit" id="mpage01" value="글작성" /> <input
							type="button" id="mpage02" value="취소"
							onclick="location.href='list.do'" />
					</div>
				</form>
			</section>
		</div>
	</div>
</body>
</html>
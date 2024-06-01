<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>새 게시글 작성</h1>
	
	<form method="post">
		<table id="articleDetail" border="1">
			<tr>
				<th>글 제목</th><td><input name="insertTitle" placeholder="제목을 입력하세요."></td>
			</tr>
			<tr height="400px">
				<th>글 내용</th><td><textarea name="insertContent" placeholder="내용을 입력하세요."></textarea></td>
			</tr>
		</table>
		<button id="insert" type="submit">작성</button>
		<button id="cancle">취소</button>
	</form>
		
</body>
</html>
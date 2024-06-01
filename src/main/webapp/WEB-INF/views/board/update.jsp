<%@page import="org.comstudy.web.board.model.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<BoardDTO> article = (List<BoardDTO>) request.getAttribute("updateArticle"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function cancle (num) {
		location.href="detail.do?num="+num;
	}
</script>
</head>
<body>
	<h1>게시글 수정</h1>
	
	<form method="post">
		<input name="articleNum" value="${article.get(i).getNum()}" hidden="true"/>
		<table id="articleDetail" border="1">
			<tr>
				<th>글 제목</th>
				<td><input name="insertTitle" 
					placeholder="제목을 입력하세요."
					value="${article.get(i).getTitle()}" ></td>
			</tr>
			<tr height="400px">
				<th>글 내용</th><td>
				<textarea name="insertContent" 
				placeholder="내용을 입력하세요." >${article.get(i).getContent()}</textarea></td>
			</tr>
		</table>
		<input value="작성" type="submit">
		<input value="취소" type="reset" onclick="cancle(${article.get(i).getNum()})">
	</form>
	
</body>
</html>
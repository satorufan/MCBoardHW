<%@page import="org.comstudy.web.board.model.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<BoardDTO> article = (List<BoardDTO>) request.getAttribute("article"); %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	function remove (num) {	//J쿼리로 구현해보기
		$.ajax({
			method : "GET",
			url : "/JspDay09Board/board/delete.do?num=" + num
		}).then((res)=>{
			alert("");
			$(location).attr("href", "http://localhost:9999/JspDay09Board/board/list.do")
		});
	}
</script>

</head>
<body>
	<h1>게시글 상세보기</h1>
	<table id="articleDetail" border="1">
		<tr>
			<th>글 번호</th><td colspan=5>${article.get(0).getNum() }</td>
		</tr>
		<tr>
			<th>글 제목</th><td>${article.get(0).getTitle() }</td>
			<th>작성자</th><td>${article.get(0).getAuthor() }</td>
			<th>조회수</th><td>${article.get(0).getReadcnt() }</td>
		</tr>
		<tr>
			<th>글 내용</th><td colspan=5>${article.get(0).getContent() }</td>
		</tr>
	</table>
	
	<a href="list.do">뒤로</a>
	<a href="update.do?num=${article.get(0).getNum() }">글 수정</a>
	<a data-num="${article.get(0).getNum() }" 
		id="${article.get(0).getNum() }"
		onclick="remove(this.id)">글 삭제</a>
	
</body>
</html>
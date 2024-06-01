<%@page import="java.util.List"%>
<%@page import="org.comstudy.web.board.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%List<BoardDTO> articles = (List<BoardDTO>) request.getAttribute("articles");%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>게시글 목록</h1>
	
	<table id="articleList" border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>Email</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="articles" items="${articles }">
			<tr>
				<td>${articles.getNum() }</td>
				<td>${articles.getAuthor() }</td>
				<td>${articles.getEmail() }</td>
				<td><a href="detail.do?num=${articles.getNum() }">${articles.getTitle() }</a></td>
				<td>${articles.getWriteday() }</td>
				<td>${articles.getReadcnt() }</td>
			</tr>
		</c:forEach>
	</table>

	<a href="input.do">글 쓰기</a>
</body>
</html>
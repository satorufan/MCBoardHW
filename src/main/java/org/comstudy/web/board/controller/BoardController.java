package org.comstudy.web.board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.web.board.model.BoardDAO;
import org.comstudy.web.board.model.BoardDTO;

@WebServlet("/board/*") // /board/ 에서 동작하는 서블릿
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAO dao = new BoardDAO();

	private String mkUrlPattern(HttpServletRequest req) {
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String urlPattern = reqUri.substring(ctxPath.length());
		
		return urlPattern;
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get 호출");
		
		String urlPattern = mkUrlPattern(req);
		System.out.println("urlPattern : " + urlPattern);
		
		String viewName = "";
		String preffix = "/WEB-INF/views";
		
		int num = 0;
		switch(urlPattern) {
		/////////////////////////////////////////////////////////////////////////
		case "/board/list.do" :	//목록 불러오기
			
			List<BoardDTO> articles = new ArrayList<BoardDTO>();
			try {
				articles = dao.selectAll(0);
			} catch (SQLException e) {}
			
			req.setAttribute("articles", articles);
			viewName = preffix + "/board/list.jsp"; break;
			
		/////////////////////////////////////////////////////////////////////////
		case "/board/input.do" :	//글 쓰기 페이지
		
		viewName = preffix + "/board/insert.jsp"; break;

		///////////////////////////////////////////////////////////////////////
		case "/board/detail.do" :	//게시글 상세보기
			
			List<BoardDTO> selectedArticle = new ArrayList<BoardDTO>();
			num = Integer.parseInt(req.getParameter("num"));
			try {
				selectedArticle = dao.selectAll(num);
			} catch (SQLException e) {}
			
			req.setAttribute("article", selectedArticle);
			viewName = preffix + "/board/select.jsp"; break;
			
		///////////////////////////////////////////////////////////////////////
		case "/board/update.do" :	//업데이트 페이지 이동
			
			num = Integer.parseInt(req.getParameter("num"));
			List<BoardDTO> updateArticle = new ArrayList<BoardDTO>();
			try {
				updateArticle = dao.selectAll(num);
			} catch (SQLException e) {}

			req.setAttribute("article", updateArticle);
			viewName = preffix + "/board/update.jsp"; break;
			
		///////////////////////////////////////////////////////////////////////
		case "/board/delete.do" :	//게시글 삭제
			
			num = Integer.parseInt(req.getParameter("num"));
			try {
				dao.delete(num);
			} catch (SQLException e) {}
			
			viewName = preffix + "/board/delete.jsp"; break;
		}
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
	
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post 호출");
		
		String urlPattern = mkUrlPattern(req);
		System.out.println("urlPattern : " + urlPattern);
		
		switch(urlPattern) {
		///////////////////////////////////////////////////////////////////////
		case "/board/input.do" :	//게시글 쓰기
			
			String title = req.getParameter("insertTitle");
			String content = req.getParameter("insertContent");
			try {
				dao.insert(new BoardDTO(0, "", "", title, content, "", "", 0, 0, 0, 0));
			} catch (SQLException e) {}
			resp.sendRedirect("list.do");break;
			
		///////////////////////////////////////////////////////////////////////
		case "/board/update.do" :	//게시글 업데이트
			
			int num = Integer.parseInt(req.getParameter("articleNum"));
			String editTitle = req.getParameter("insertTitle");
			String editContent = req.getParameter("insertContent");
			try {
				dao.update(new BoardDTO(num, "", "", editTitle, editContent, "", "", 0, 0, 0, 0));
			} catch (SQLException e) {}
			resp.sendRedirect("detail.do?num="+num);break;
			
		}
		
	}

}

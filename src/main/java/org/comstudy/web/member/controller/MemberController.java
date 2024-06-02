package org.comstudy.web.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//HttpSession session;
	
	public HttpSession checkLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session;
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		System.out.println(session);
		
		String viewName = "";
		String preffix = "/WEB-INF/views";
		
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		int beginIdx = ctxPath.length();
		
		String urlPattern = reqUri.substring(beginIdx);
		System.out.println(urlPattern);
		
		if(!"/".equals(urlPattern)) {
			System.out.println("접속");
		}
		
		if("/member/login.do".equals(urlPattern)) {
			
			session.setAttribute("id", "임시사용자");
			viewName = preffix + "/member/login.jsp";
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}

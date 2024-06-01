package org.comstudy.web.board.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Controller의 일을 분화 시킨 클래스
//Command 구현체에서 DAO 객체를 사용한다.
public interface Command {
	
	String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ;
	
}

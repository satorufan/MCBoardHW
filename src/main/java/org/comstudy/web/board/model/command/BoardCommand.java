package org.comstudy.web.board.model.command;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.web.board.model.BoardDAO;
import org.comstudy.web.board.model.BoardDTO;

public class BoardCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		return null;
	}
	
	//글 불러오기
	public List<BoardDTO> selectAll(ResultSet rs) throws SQLException {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		while(rs.next()) {
			int num = rs.getInt(1);
			String author = rs.getString(2);
			String email = rs.getString(3);
			String title = rs.getString(4);
			String content = rs.getString(5);
			String passwd = rs.getString(6);
			String writeday = rs.getString(7);
			int readcnt = rs.getInt(8);
			int rep_root = rs.getInt(9);
			int rep_step = rs.getInt(10);
			int rep_indent = rs.getInt(11);
			list.add(new BoardDTO(num, author, email, title, content, passwd, writeday,
					readcnt, rep_root, rep_step, rep_indent));
		}
		return list;
	}
	
	//글 작성
	public void insert(PreparedStatement pstmt, BoardDTO dto, BoardDAO dao) throws SQLException {
		
		pstmt.setString(1, "test");
		pstmt.setString(2, "test@email.com");
		pstmt.setString(3, dto.getTitle());
		pstmt.setString(4, dto.getContent());
		pstmt.setString(5, "12345");
		pstmt.execute();
		
	}
	
	//글 수정
	public void update(PreparedStatement pstmt, BoardDTO dto, BoardDAO dao) throws SQLException {
		
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setInt(3, dto.getNum());
		pstmt.execute();
		
	}

}

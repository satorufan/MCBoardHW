package org.comstudy.web.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy.web.board.dbcp.JdbcUtil;
import org.comstudy.web.board.model.command.BoardCommand;

//여기가 JDBC에서 데이터베이스를 불러와 
//SQL문을 이용하여 데이터를 건드릴 곳이다.
public class BoardDAO {
	public static List<BoardDTO> article = new ArrayList<BoardDTO>();
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	BoardCommand bc = new BoardCommand();
	
	//글 목록 불러오기 및 선택글(세부사항) 불러오기
	public List<BoardDTO> selectAll(int num) throws SQLException {
		
		//게시글 데이터 베이스 객체 불러오기
		conn = JdbcUtil.getConnection();
		
		//SQL SELECT
		String sql = "select * from board";
		//세부사항일 경우 추가.
		if(num > 0) sql = "select * from board where num="+num;
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		article = bc.selectAll(rs);
		return article;
	}
	
	//글 쓰기
	public void insert(BoardDTO dto) throws SQLException {
		
		//게시글 데이터 베이스 객체 불러오기
		conn = JdbcUtil.getConnection();
		
		//SQL INSERT
		String sql1 = "insert into board (author, email, title, content, passwd) ";
		String sql2 = "values ( ?, ?, ?, ?, ?)";
		String sql = sql1.concat(sql2);
		
		pstmt = conn.prepareStatement(sql);
		
		bc.insert(pstmt, dto, new BoardDAO());
	}
	
	//글 삭제
	public void delete(int num) throws SQLException {
		
		//게시글 데이터 베이스 객체 불러오기
		conn = JdbcUtil.getConnection();
		
		//SQL SELECT
		String sql = "delete from board where num="+num;
		
		pstmt = conn.prepareStatement(sql);
		pstmt.execute();
	}
	
	//글 수정
	public void update(BoardDTO dto) throws SQLException {
		
		//게시글 데이터 베이스 객체 불러오기
		conn = JdbcUtil.getConnection();
		
		//SQL UPDATE
		String sql = "update board set title=?, content=? where num=?";
		pstmt = conn.prepareStatement(sql);
		
		bc.update(pstmt, dto, new BoardDAO());
	}
	
}

package com.yedam.mvc.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yedam.mvc.board.service.BoardVO;
import com.yedam.mvc.common.DAO;

public class BoardsDAO extends DAO {
	// 보드테이블 접속하는 dao
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	// ctl + shift + x = 일괄 대문자로 변경
	private final String BOARDSELECTLIST = "SELECT * FROM BOARDS";
	
	public ArrayList<BoardVO> selectList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		try {
			psmt = conn.prepareStatement(BOARDSELECTLIST);
			rs = psmt.executeQuery(); // record set 리턴
			while(rs.next()) { // rs.nest() = record cursor 하나씩 이동
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
				list.add(vo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(); // 닫히는 순서는 실행의 반대
		}
		
		return list;
	}
	
	public BoardVO select(BoardVO vo) {
		// 한 개 레코드 조회 구문 작성
		return vo;
	}
	
	public int insert(BoardVO vo) {
		int n = 0;
		// 여기에 입력작업을 쓴다.
		
		return n;
	}
	
	public int update(BoardVO vo) {
		int n = 0;
		// 여기에 입력작업을 쓴다.
		
		return n;
	}
	
	public int delete(BoardVO vo) {
		int n = 0;
		// 여기에 입력작업을 쓴다.
		
		return n;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

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
	
	
	// SQL 쿼리문 // ctl + shift + x = 일괄 대문자로 변경
	// final = 변하지 않는 '상수'로 처리해주기 위해 사용(쿼리문은 변경되면 안되기 때문에)
	private final String BOARDSELECTLIST = "SELECT * FROM BOARDS ORDER BY BOARD_NO DESC";
	private final String BOARDSELECT = "SELECT * FROM BOARDS WHERE BOARD_NO = ?";
	private final String BOARDINSERT = "INSERT INTO BOARDS VALUES(?,?,?,?,?)";
	private final String BOARDDELETE = "DELETE FROM BOARDS WHERE BOARD_NO = ?";
	private final String BOARDUPDATE = "UPDATE BOARDS SET TITLE = ?, CONTENT = ? WHERE BOARD_NO = ?";
	
	// 전체 리스트 조회
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
	
	// 한 개 레코드 조회
	public BoardVO select(BoardVO vo) {
		
		// 한 개 레코드 조회 구문 작성
		try {
			psmt = conn.prepareStatement(BOARDSELECT);
			psmt.setInt(1, vo.getBoardNo());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
			
		return vo;
	}
	
	// boards 테이블에 데이터 삽입
	public int insert(BoardVO vo) {
		int n = 0;
		// 여기에 입력작업을 쓴다.
		
		try {
			psmt = conn.prepareStatement(BOARDINSERT);
			psmt.setInt(1, vo.getBoardNo());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setDate(5, vo.getCreationDate());
			n = psmt.executeUpdate();
			
			System.out.println(n + "건 입력");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	// Board Update
	public int update(BoardVO vo) {
		int n = 0;
		// 여기에 수정작업을 쓴다.
		
		try{
			psmt = conn.prepareStatement(BOARDUPDATE);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getBoardNo());
			n = psmt.executeUpdate();
			
			System.out.println(n + "개 업데이트");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
			
		return n;
	}
	
	// 테이블 데이터 삭제
	public int delete(BoardVO vo) {
		int n = 0;
		// 여기에 삭제작업을 쓴다.
		
		try {
			psmt = conn.prepareStatement(BOARDDELETE);
			psmt.setInt(1, vo.getBoardNo());
			n = psmt.executeUpdate();
			
			System.out.println(n + "개 삭제");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
			System.out.println("DB 연결 종료");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
} // end of class

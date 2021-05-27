package com.board.dao;

import static com.board.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.MyBoardDto;

// DAO : Data Access Object : db연결
public class MyBoardDao { // dao -----> db -----> dao

	// 전체출력
	public List<MyBoardDto> selectList(){ // parameter : 메소드 외부에서 전달되는 값을 받아서 메소드 내부에서 사용하는 변수
		
		// 1 driver 연결
		// 2 계정 연결
		Connection con = getConnection();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
				   + " FROM MYBOARD "
				   + " ORDER BY SEQ DESC ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		// MyBoardDto dto = new MyBoardDto(); 여기다가 쓰면 안된다. 
		
		try {
			// 3 query 준비
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비" + sql);
		
			// 4 query 실행 및 리턴
			rs = pstm.executeQuery();
			while(rs.next()) {
				MyBoardDto dto = new MyBoardDto(); // 여기다 써야 한다.
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5 db 종료
			close(rs);
			close(pstm);
			close(con);
		}
		
		return list;
	}
	
	// 하나 출력
	public MyBoardDto selectOne(int seq) {
		Connection con = getConnection();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
				   + " FROM MYBOARD "
				   + " WHERE SEQ = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyBoardDto dto = new MyBoardDto();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("3. query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				dto = new MyBoardDto(rs.getInt("SEQ"),
									 rs.getString("WRITER"),
									 rs.getString("TITLE"),
									 rs.getString("CONTENT"),
									 rs.getDate("REGDATE"));
			}
			System.out.println("4. query 실행 실행 및 리턴");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		return dto;
	}
	
	// 추가
	public int insert(MyBoardDto dto) {
		Connection con = getConnection();
		String sql = " INSERT INTO MYBOARD "
				   + " VALUES (MYBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("3. query 준비 : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			if (res > 0) {
					commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
	
		return res;
	}
	// 수정
	public int update(MyBoardDto dto) {
		Connection con = getConnection();
		String sql = " UPDATE MYBOARD "
				   + " SET TITLE = ?, CONTENT = ? "
				   + " WHERE SEQ = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("3. query 준비 : " + sql);
			
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
			System.out.println("4. query 실행 및 리턴");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		return res;
	}
	
	// 삭제
	public int delete(int seq) { // primary key만 넣으면 된다. 해당 db의(where seq = 1;) row를 찾아 삭제하자.
		Connection con = getConnection();
		String sql = " DELETE FROM MYBOARD "
				   + " WHERE SEQ = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("3. query 준비 : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
	
		return res;
	}
}
package com.cal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.cal.db.JDBCTemplate.*;
import com.cal.dto.CalDto;

public class CalDao {

	public int insertCalBoard(CalDto dto) {
		Connection con = getConnection();
		String sql = " INSERT INTO CALBOARD " 
				   + " VALUES(CALBOARDSEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getId());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			pstm.setString(4, dto.getMdate());
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
	
	public List<CalDto> getCalList(String id, String yyyyMMdd) {
		Connection con = getConnection();
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, MDATE, REGDATE "
				   + " FROM CALBOARD "
				   + " WHERE ID = ? "
				   + " AND SUBSTR(MDATE, 1, 8) = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<CalDto> list = new ArrayList<CalDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMMdd);
			System.out.println("3. query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				CalDto dto = new CalDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
				list.add(dto);
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return list;
	}
	
	public List<CalDto> getCalViewList(String id, String yyyyMM){
		Connection con = getConnection();
		String sql = " SELECT * "
				   + " FROM "
				   + "	( "
				   + "	SELECT (ROW_NUMBER() OVER(PARTITION BY SUBSTR(MDATE, 1, 8) ORDER BY MDATE))RN, SEQ, ID, TITLE, CONTENT, MDATE, REGDATE "
				   + "	FROM CALBOARD "
				   + "	WHERE ID = ? "
				   + "	AND SUBSTR(MDATE, 1, 6)= ? "
				   + "	) "
				   + " WHERE RN BETWEEN 1 AND 4 "; // 보이는 최대 갯수 : 4개까지 나온다.
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<CalDto> list = new ArrayList<CalDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMM);
			System.out.println("3. query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while (rs.next()) {
				CalDto dto = new CalDto(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		return list;
		
	}
	
	public int getCalViewCount(String id, String yyyyMMdd) {
		
		Connection con = getConnection();
		String sql = " SELECT COUNT(*) "
				   + " FROM CALBOARD "
				   + " WHERE ID = ? "
				   + " AND SUBSTR(MDATE, 1, 8) = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null; // select 구문이기 때문에 res로 받는 게 아니라 resultSet으로 받는다.
		int count = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMMdd);
			System.out.println("3. query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while (rs.next()) {
				count = rs.getInt(1);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con); // con -> pstm -> rs 순서이기 때문에 rs -> pstm -> con 순서대로 close 해야한다. nullException이 뜰 수 있다.
			System.out.println("5. db 종료");
		}
		
		return count;
	}
}

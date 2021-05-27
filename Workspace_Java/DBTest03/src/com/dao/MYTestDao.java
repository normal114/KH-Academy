package com.dao;

import static com.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.MYTestDto;

// Data Access Object(DAO) : DB와 접근하는 객체. 여기서 syso는 안 찍는다. Java랑 DB 연결은 DAO가 맡는다. Java랑 DAO 사이는 무엇이 연결해줄까?
// import static : class.method 하고 호출할 때, class 생략.
public class MYTestDao { 

	// 전체출력
	public List<MYTestDto> selectList() {
		// 1번이랑 2번
		// Connection con = JDBTemplate.getConnection(); // import static com.common.JDBCTemplate.*; 때문에 밑에 내용만 썼다.
		Connection con = getConnection();
		String sql = " SELECT MNO, MNAME, NICKNAME "
					+ " FROM MYTEST ";
		Statement stmt = null;
		ResultSet rs = null;
		List<MYTestDto> list = new ArrayList<MYTestDto>(); // list가 MYTestDto에서 temp.setMno, temp.setMname, temp.setNickname 내용을 관리한다.
		
		try {
			// 3.
			stmt = con.createStatement();
		
			// 4.
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MYTestDto temp = new MYTestDto();
				temp.setMno(rs.getInt("MNO"));
				temp.setMname(rs.getString("MNAME"));
				temp.setNickname(rs.getString("NICKNAME"));
				
				list.add(temp);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		
		return list;

	}
	
	// 추가
	public int insert(MYTestDto dto) {
		
		Connection con = getConnection();
		String sql = " INSERT INTO MYTEST "
					+ " VALUES(?, ?, ?) ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			// 3.
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getMno());
			pstm.setString(2, dto.getMname());
			pstm.setString(3, dto.getNickname());
		
			// 4.
			res = pstm.executeUpdate();
			if (res > 0) { // res > 0 성공했다의 뜻(row가 추가되었다)
				commit(con); // 이거 안 쓰면 껐다 켰을 때 날라간다.	
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 
			close(pstm);
			close(con);
		}
		
		return res;
	}
	// 선택 출력
	public MYTestDto selectOne(int mno) {
		Connection con = getConnection();
		String sql = " SELECT MNO, MNAME, NICKNAME "
				+ " FROM MYTESTY"
				+ " WHERE MNO = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MYTestDto dto = new MYTestDto(); // 객체를 새로 만들어 놓고 리턴해주는 거(return dto);랑 null을 잡아놓고 리턴하는 거랑 무슨차이가 있는가? return=dto; 사이에 값이 없으면  
		
		try {
			// 3.
			pstm = con.prepareStatement(sql); // preparedStatement이기 때문에 여기 sql를 가져온다.
			pstm.setInt(1, mno);
			
			// 4.
			rs = pstm.executeQuery(); // 하지만 여기는 (); 비워준다.
			while(rs.next()) {
				dto.setMno(rs.getInt("MNO"));
				dto.setMname(rs.getNString("MNAME"));
				dto.setNickname(rs.getString("NICKNAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return dto; // return은 항상 먼저 써놓아야 한다. 만약 안 써놓으면 자동으로 return = null; 처리가 되어서 에러가 난다.
		
	}
	
	public MYTestDto selectOne2(int mno) {
		Connection con = getConnection();
		// 3.
		String sql = " SELECT * "
				   + " FROM MYTEST "
				   + " WHERE MNO = " + mno;
		Statement stmt = null;
		// 4.
		ResultSet rs = null;
		MYTestDto dto = null; // dto는 null을 갖는다.
		
		try {
			// 3.
			stmt = con.createStatement(); // Statement문이기 때문에 (); 비워준다. 왜냐하면 sql로 잡지 않고 리턴될 때 sql로 잡기 때문이다.
			
			// 4.
			rs = stmt.executeQuery(sql); // 하지만 여기는 (sql);을 넣어준다.
			while (rs.next()) {
				dto = new MYTestDto(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		
		return dto;
	
	}
	// 수정
	public int update(MYTestDto dto) {
		Connection con = getConnection();
		String sql = " UPDATE MYTEST "
				   + " SET MNAME = ?, NICKNAME = ? "
				   + " WHERE MNO = ? "; // 숫자는 변경 불가. 왜냐하면 찾기 기준이 번호로 찾기 때문에 변경될 수 없다.
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			// 3
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMname());
			pstm.setString(2, dto.getNickname());
			pstm.setInt(3, dto.getMno());
			
			// 4.
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
				
	}
	
	// 삭제
	public int delete (int mno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = " DELETE FROM MYTEST "
				   + " WHERE MNO = ? ";
		int res = 0;
		
		try {
			// 3.
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, mno);
		
			// 4.
			res = pstm.executeUpdate();
			if (res > 0 ) {
				commit(con);
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
}
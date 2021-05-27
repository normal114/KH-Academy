package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.MemberDto;

import static com.common.JDBCTemplate.*;

public class MemberDaoImpl implements MemberDao {

	
	@Override
	public List<MemberDto> selectList() {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			// 3.
			stmt = con.createStatement();
		
			// 4.
			rs = stmt.executeQuery(SELECT_LIST_SQL);
			// 번호, 이름, 나이, 성별, 지역, 하는 일, 전화번호, 이메일
			while (rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setM_no(rs.getInt(1));
				dto.setM_name(rs.getString(2));
				dto.setM_age(rs.getInt(3));
				dto.setM_gender(rs.getString(4));
				dto.setM_location(rs.getString(5));
				dto.setM_job(rs.getString(6));
				dto.setM_tel(rs.getString(7));
				dto.setM_email(rs.getString(8));
				
				list.add(dto);
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

	@Override
	public MemberDto selectOne(int m_no) {  // controller -> biz -> dao -> db(table정보) -> biz -> controller
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MemberDto dto = new MemberDto(); // 객체를 새로 만들어 놓고 리턴해주는 거(return dto);랑 null을 잡아놓고 리턴하는 거랑 무슨차이가 있는가? return=dto; 사이에 값이 없으면  
		
		try {
			// 3.
			pstm = con.prepareStatement(SELECT_ONE_SQL); // preparedStatement이기 때문에 여기 SELECT_ONE_SQL 상수를 가져온다.
			pstm.setInt(1, m_no);
			
			// 4.
			rs = pstm.executeQuery(); // 하지만 여기는 (); 비워준다.
			while(rs.next()) {
				dto.setM_no(rs.getInt("M_NO")); // 순서가 헷갈릴 것 같으면 왼쪽처럼 쿼리 이름으로 써 놓으면 된다.
				dto.setM_name(rs.getString("M_NAME"));
				dto.setM_age(rs.getInt("M_AGE"));
				dto.setM_gender(rs.getString("M_GENDER"));
				dto.setM_location(rs.getString("M_LOCATION"));
				dto.setM_job(rs.getString("M_JOB"));
				dto.setM_tel(rs.getString("M_TEL"));
				dto.setM_email(rs.getString("M_EMAIL"));
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
		
	@Override
	public int insert(MemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			// 3.
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getM_name());
			pstm.setInt(2, dto.getM_age());
			pstm.setString(3, dto.getM_gender());
			pstm.setString(4, dto.getM_location());
			pstm.setString(5, dto.getM_job());
			pstm.setString(6, dto.getM_tel());
			pstm.setString(7, dto.getM_email());
			
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
		
		return res; // 출력했을시 시퀀스 번호가 21로 출력된다면 그냥 시퀀스 에러이다. 신경쓸 필요 없다. 
	}
		
	@Override
	public int update(MemberDto dto) {
		
		// 1.
		// 2.
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			// 3
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setString(1, dto.getM_name());
			pstm.setInt(2, dto.getM_age());
			pstm.setString(3, dto.getM_gender());
			pstm.setString(4, dto.getM_location());
			pstm.setString(5, dto.getM_job());
			pstm.setString(6, dto.getM_tel());
			pstm.setString(7, dto.getM_email());
			pstm.setInt(8, dto.getM_no()); // 8번 getM_no를 넣어줘야 한다. no가 마지막인 이유는 마지막 ?가 no이기 때문이다.
			
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
	
	@Override
	public int delete(int m_no) {
		// 1. 
		// 2. getConnection();에서 1, 2번이 끝났다. con이 JDBCTemplate의 return con; 값을 가져올 것이다.
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			// 3.
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, m_no); // Controller -> Biz -> Dao -------- DataBase 여기까지가 dao에서 db로 전달하기 전까지의 코 
			
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
}

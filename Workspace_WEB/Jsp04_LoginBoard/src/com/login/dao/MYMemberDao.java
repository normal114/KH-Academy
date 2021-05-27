package com.login.dao;

import static com.login.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.dto.MYMemberDto;

public class MYMemberDao {

	/*
	 * 관리자(ADMIN) 기능
	 * 1. 회원 전체 정보 확인 (탈퇴한 회원도 포함)
	 * 2. 회원 전체 정보 확인 (MYENABLED='Y'인 -> 탈퇴안한 회원들의 정보)
	 * 3. 회원 등급 조정 (ADMIN <-> USER)
	 */
	
	// 1. 전체정보
	public List<MYMemberDto> selectAllUser(){
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				   + " FROM MYMEMBER "
				   + " ORDER BY MYNO DESC ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MYMemberDto> list = new ArrayList<MYMemberDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				MYMemberDto dto = new MYMemberDto(rs.getInt("MYNO"),
												  rs.getString("MYID"),
												  rs.getString("MYPW"),
												  rs.getString("MYNAME"),
												  rs.getString("MYADDR"),
												  rs.getString("MYPHONE"),
												  rs.getString("MYEMAIL"),
												  rs.getString("MYENABLED"),
												  rs.getString("MYROLE"));
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
	// 2. 전체정보(탈퇴안한)
	public List<MYMemberDto> selectEnabledUser(){
		Connection con = getConnection();		
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				   + " FROM MYMEMBER "
				   + " WHERE MYENABLED = 'Y' "; // 싱글쿼테이션이 상당히 중요하다. 헷갈리면 대신 ?를 넣어도 된다. 
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MYMemberDto> list = new ArrayList<MYMemberDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				MYMemberDto dto = new MYMemberDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));
				
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
	// 3. 회원 등급 조정
	public int updateRole(int myno, String myrole) {
		Connection con = getConnection();
		String sql = " UPDATE MYMEMBER "
				   + " SET MYROLE = ? " // myrole을 우리가 바꿀 것이다.
				   + " WHERE MYNO = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myrole);
			pstm.setInt(2, myno);
			System.out.println("3. query 준비 : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("4. quey 생성 및 리턴");
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
	
	/*
	 * 사용자(USER) 기능
	 * 1. 로그인
	 * 3. 회원가입 <- 2. 아이디 중복체크
	 * 4. 내 정보 조회
	 * 5. 내 정보 수정
	 * 6. 회원 탈퇴 (delete 안쓸것! update : myenabled를 n으로 바꾸자.)
	 */
	
	// 1. 로그인
	public MYMemberDto login(String myid, String mypw) {
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				   + " FROM MYMEMBER "
				   + " WHERE MYID = ? "
				   + " AND MYPW = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// side effect
		MYMemberDto dto = null; 
		// null로 하느냐 MYMemberDto dto로 하느냐에 따라 결과가 달라짐. 
		// 아이디는 맞는데 비밀번호가 틀리면 null이 된다.
		// new MYBordDto dto로 해놓으면 무조건 로그인 성공이 뜬다. null이 되지 않기 때문이다. dto에 객체가 들어가 있기 때문이다.
		
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			pstm.setString(2, mypw);
			System.out.println("3. query 준비 : " + sql);
		
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				dto = new MYMemberDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
			System.out.println("5. db 종료");
		}
	
		return dto; // 아이디는 맞는데 비밀번호가 틀리면 null이 된다. 
	}
	// 2. 중복체크
	public MYMemberDto idCheck(String myid) {
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				   + " FROM MYMEMBER "
				   + " WHERE MYID = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MYMemberDto dto = new MYMemberDto(); // logincontroller에서 (dto.getMyid() != null)이라는 조건을 달고 있기 때문.
		
		
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			System.out.println("3. query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				dto = new MYMemberDto(rs.getInt("MYNO"),
									  rs.getString("MYID"),
									  rs.getString("MYPW"),
									  rs.getString("MYNAME"),
									  rs.getString("MYADDR"),
									  rs.getString("MYPHONE"),
									  rs.getString("MYEMAIL"),
									  rs.getString("MYENABLED"),
									  rs.getString("MYROLE"));
			}
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
	// 3. 회원가입
	public int insertUser(MYMemberDto dto) {
		return 0;
	}
	// 4. 정보 조회
	public MYMemberDto selectUser(int myno) {
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				   + " FROM MYMEMBER "
				   + " WHERE MYNO = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MYMemberDto dto = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("3. query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				dto = new MYMemberDto(rs.getInt("MYNO"),
									  rs.getString("MYID"),
									  rs.getString("MYPW"),
									  rs.getString("MYNAME"),
									  rs.getString("MYADDR"),
									  rs.getString("MYPHONE"),
									  rs.getString("MYEMAIL"),
									  rs.getString("MYENABLED"),
									  rs.getString("MYROLE"));
				}
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
	// 5. 정보 수정
	public int updateUser(MYMemberDto dto) {
		return 0;
	}
	// 6. 회원 탈퇴 (update)
	public int deleteUser(int myno) {
		return 0;
	}
}

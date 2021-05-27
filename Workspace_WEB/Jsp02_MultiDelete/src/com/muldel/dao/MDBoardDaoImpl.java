package com.muldel.dao;

import static com.muldel.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muldel.dto.MDBoardDto;

public class MDBoardDaoImpl implements MDBoardDao {

	@Override
	public List<MDBoardDto> selectList() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		// MDBoardDto dto$$; 이렇게 쓰면 안된다.
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("3. query 준비 : " + SELECT_LIST_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 생성 및 리턴");
			while(rs.next()) { // while로 인해 내부에 있던 dto는 사라지고 다시 시작된다. 변수의 스코프라 한다. 
				MDBoardDto dto = new MDBoardDto(); // 이걸 밖으로 빼서 쓰면 dto 똑같은 글이 나온다. 똑같은 객체를 참조하기 때문이다.
				dto.setSeq(rs.getInt("SEQ"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setRegdate(rs.getDate("REGDATE"));
				
				list.add(dto); // 이거 까먹은면 작성한 글이 존재하지 않습니다.
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

	@Override
	public MDBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// MDBordDto dto = null; 와 MDBoardDto dto = new MDBoardDto(); 같이 작동은 되지만 차이가 있다. npe hell을 구글에 검색하면 그 차이를 알 수 있다.
		MDBoardDto dto = new MDBoardDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);;
			pstm.setInt(1, seq);
			System.out.println("3. query 준비 : " + SELECT_ONE_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴 ");
			while (rs.next()) {
				dto = new MDBoardDto(rs.getInt("SEQ"),
									 rs.getString("WRITER"),
									 rs.getString("TITLE"),
									 rs.getString("CONTENT"),
									 rs.getDate("REGDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close(rs, pstm, con); 만약 close(rs, pstm, con)을 JDBCTemplate에 만들어 놓았다면 이렇게 쓰는 게 편하다.
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		return dto;
	}

	@Override
	public int insert(MDBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("3. query 준비 : " + INSERT_SQL);
			
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

	@Override
	public int update(MDBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("3. query 준비 : " + UPDATE_SQL);
		
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

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int multiDelete(String[] seqs) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		int[] cnt = null;
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			for (int i = 0; i < seqs.length; i++) {
				pstm.setString(1, seqs[i]); // 어떻게 스트링으로 쓸 수 있는가? '1'이나 1은 똑같기 때문.
				pstm.addBatch();
				System.out.println("3. query 준비 : " + DELETE_SQL + " (삭제할 번호 : " + seqs[i] + ")");
				
			}
			
			cnt = pstm.executeBatch(); // executeBatch는 [-2, -2, -2, -3] 이런 식으로 배열로 리턴되기 때문에 int res를 쓰면 안되고 [] cnt로 작성해야 한다.
			System.out.println("4. query 실행 및 리턴");
			
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] == -2) {
					res++; // 성공한 갯수를 가지고 왔다.
				}
			}
			
			if (seqs.length == res) { // res랑 처음에 넣어준 갯수랑 같다면 commit 시키자.
				commit(con);
			} else {
				System.out.println("성공한 갯수가 모자랍니다."); 
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

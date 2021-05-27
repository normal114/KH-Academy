package com.answer.dao;

import static com.answer.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.answer.dto.AnswerDto;

public class AnswerDaoImpl implements AnswerDao {

	@Override
	public List<AnswerDto> selectList() {
		// 1. 2.
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null; // dao를 select로 db에 요청하고 그걸 테이블로 만들어 주는데 이것을 resultSet에 담아준다. Insert, Update, Delete는 rows의 갯수가 응답되기 때문에 int가 사용된다.
		List<AnswerDto> list = new ArrayList<AnswerDto>();
		
		try {
			// 3.
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("3. query 준비 : " + SELECT_LIST_SQL);
			// 4.
			rs = pstm.executeQuery(); // rs에 값을 가져왔다. 이것을 while을 통해 받는다.
			System.out.println("4. query 실행 및 리턴");
			while (rs.next()) { // rs.next는 row 하나 가져오는 얘
				AnswerDto dto = new AnswerDto();
				dto.setBoardno(rs.getInt(1)); // 얘는 column 하나 가져오는 얘
				dto.setGroupno(rs.getInt(2));
				dto.setGroupseq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setWriter(rs.getString(7));
				dto.setRegdate(rs.getDate(8));

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

	@Override
	public AnswerDto selectOne(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		AnswerDto dto = new AnswerDto(); // 만약 여기서 null을 했다면 아래가 달라진다.
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, boardno);
			System.out.println("3. query 준비 : " + SELECT_ONE_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while (rs.next()) {
				dto.setBoardno(rs.getInt("BOARDNO")); // 여기서 dto = new AnswerDto(); 객체 생성을 해야 한다.
				dto.setGroupno(rs.getInt("GROUPNO"));
				dto.setGroupseq(rs.getInt("GROUPSEQ"));
				dto.setTitletab(rs.getInt("TITLETAB"));			
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setRegdate(rs.getDate("REGDATE"));
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

	@Override
	public int boardInsert(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(BOARD_INSERT_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(3, dto.getWriter());
			System.out.println("3. query 준비 : " + BOARD_INSERT_SQL);
			
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
	public int boardUpdate(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(BOARD_UPDATE_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getBoardno());
			System.out.println("3. query 준비 : " + BOARD_UPDATE_SQL);
		
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
		}
		
		return res;
		
	}

	@Override
	public int boardDelete(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(BOARD_DELETE_SQL);
			pstm.setInt(1, boardno);
			System.out.println("3. query 준비 : " + BOARD_DELETE_SQL);
			
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
	public int answerUpdate(int parentBoardNo) { // 답변을 작성하기 전에 그룹 번호가 부모랑 같지만 그룹순서는 높여줌.
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(ANSWER_UPDATE_SQL);
			pstm.setInt(1, parentBoardNo); // 부모의 그룹번호랑 같은 번호
			pstm.setInt(2, parentBoardNo); // 부모의 그룹순서보다 큰 순서
			System.out.println("3. query 준비 : " + ANSWER_UPDATE_SQL);
			
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
	public int answerInsert(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(ANSWER_INSERT_SQL);
			pstm.setInt(1, dto.getBoardno()); // dao에서 answer_insert_sql을 살펴보면 부모 번호를 3개(where board = ?) 가져와야 한다.
			pstm.setInt(2, dto.getBoardno());
			pstm.setInt(3, dto.getBoardno());
			pstm.setString(4, dto.getTitle());
			pstm.setString(5, dto.getContent());
			pstm.setString(6, dto.getWriter());
			System.out.println("3. query 준비 : " + ANSWER_INSERT_SQL);
			
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

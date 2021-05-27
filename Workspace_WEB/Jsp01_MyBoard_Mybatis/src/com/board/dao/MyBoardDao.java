package com.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.db.SqlMapConfig;
import com.board.dto.MyBoardDto;

public class MyBoardDao extends SqlMapConfig {

	public List<MyBoardDto> selectList() {
		SqlSession session = null;

		List<MyBoardDto> list = new ArrayList<MyBoardDto>();

		session = getSqlSessionFactory().openSession(true);
		list = session.selectList("boardmapper.selectList");

		session.close();

		return list;
	}

	public MyBoardDto selectOne(int seq) {

		SqlSession session = null;

		MyBoardDto dto = new MyBoardDto();

		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne("boardmapper.selectOne", seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return dto;
	}

	// 추가
	public int insert(MyBoardDto dto) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true);) {
			res = session.insert("boardmapper.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	// 수정
	public int update(MyBoardDto dto) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true);) {
			res = session.update("boardmapper.update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	// 삭제
	public int delete(int seq) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true);) {
			res = session.delete("boardmapper.delete", seq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}
}
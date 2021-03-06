package com.mvc.semi.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.semi.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardDto> accompany_selectList() {

		List<BoardDto> list = new ArrayList<BoardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "accompany_selectList");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<BoardDto> notice_selectList() {

		List<BoardDto> list = new ArrayList<BoardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "notice_selectList");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<BoardDto> photo_selectList() {

		List<BoardDto> list = new ArrayList<BoardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "photo_selectList");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public BoardDto accompany_selectOne(int postId) {

		BoardDto dto = new BoardDto();

		try {
			dto = sqlSession.selectOne(NAMESPACE + "accompany_selectOne", postId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public BoardDto notice_selectOne(int postId) {

		BoardDto dto = new BoardDto();

		try {
			dto = sqlSession.selectOne(NAMESPACE + "notice_selectOne", postId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public BoardDto photo_selectOne(int postId) {

		BoardDto dto = new BoardDto();

		try {
			dto = sqlSession.selectOne(NAMESPACE + "photo_selectOne", postId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public int accompany_insert(BoardDto dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "accompany_insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int photo_insert(BoardDto dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "photo_insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int notice_insert(BoardDto dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "notice_insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int accompany_update(BoardDto dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "accompany_update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int photo_update(BoardDto dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "photo_update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int notice_update(BoardDto dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "notice_update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int accompany_delete(int postId) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "accompany_delete", postId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int notice_delete(int postId) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "notice_delete", postId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public List<BoardDto> notice_selectListPaging(int startRow, int endRow) {

		List<BoardDto> list = new ArrayList<BoardDto>();
		endRow += startRow;

		Map<String, Object> map = new HashMap<>();

		map.put("startRow", startRow);
		map.put("endRow", endRow);

		try {
			list = sqlSession.selectList(NAMESPACE + "notice_selectListPaging", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<BoardDto> accompany_selectListPaging(int startRow, int endRow) {

		List<BoardDto> list = new ArrayList<BoardDto>();
		endRow += startRow;

		Map<String, Object> map = new HashMap<>();

		map.put("startRow", startRow);
		map.put("endRow", endRow);

		try {
			list = sqlSession.selectList(NAMESPACE + "accompany_selectListPaging", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<BoardDto> photo_selectListPaging(int startRow, int endRow) {

		List<BoardDto> list = new ArrayList<BoardDto>();
		endRow += startRow;

		Map<String, Object> map = new HashMap<>();

		map.put("startRow", startRow);
		map.put("endRow", endRow);

		try {
			list = sqlSession.selectList(NAMESPACE + "photo_selectListPaging", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int accompanyGetTotalCount() {

		int res = 0;

		try {
			res = sqlSession.selectOne("accompanyGetTotalCount");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int noticeGetTotalCount() {
		int res = 0;

		try {
			res = sqlSession.selectOne("noticeGetTotalCount");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int photoGetTotalCount() {

		int res = 0;

		try {
			res = sqlSession.selectOne("photoGetTotalCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public BoardDto selectOneByPostId(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

}

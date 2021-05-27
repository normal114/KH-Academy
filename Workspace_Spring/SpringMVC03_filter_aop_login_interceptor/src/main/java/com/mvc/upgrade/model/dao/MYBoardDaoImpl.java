package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.Criteria;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Repository
public class MYBoardDaoImpl implements MYBoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MYBoardDto> selectList(Criteria cri) {

		List<MYBoardDto> list = new ArrayList<MYBoardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "selectListPage", cri);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public int listCount() {
		
		return sqlSession.selectOne(NAMESPACE + "listCount");

	}

	@Override
	public MYBoardDto selectOne(int myno) {
		MYBoardDto dto = null;

		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}
	
	@Override
	public int insert(MYBoardDto dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int update(MYBoardDto dto) {

		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int myno) {
		
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int multiDelete(String[] mynoes) {
		
		int count = 0;
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("mynoes", mynoes);
		
		try {
			count = sqlSession.delete(NAMESPACE + "multiDelete", map);
			if(count == mynoes.length) {
				sqlSession.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	@Override
	public int boardCount(int myno) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "boardCount", myno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int answerUpdate(int parentBoardNo) {

		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "answerupdate", parentBoardNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}
		
	@Override
	public int answerInsert(MYBoardDto dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "answerinsert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public List<MYBoardDto> selectListPaging(int startRow, int endRow) {
		
		List<MYBoardDto> list = new ArrayList<MYBoardDto>();
		endRow += startRow;
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectListPage", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int getTotalCount() {
		
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "getTotalCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
}

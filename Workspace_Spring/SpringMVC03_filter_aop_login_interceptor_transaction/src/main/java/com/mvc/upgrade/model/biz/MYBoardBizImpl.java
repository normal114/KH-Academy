package com.mvc.upgrade.model.biz;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.MYBoardDao;
import com.mvc.upgrade.model.dto.Criteria;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Service
public class MYBoardBizImpl implements MYBoardBiz {

	@Autowired
	private MYBoardDao dao;

	@Override
	public List<MYBoardDto> selectList(Criteria cri) {
		return dao.selectList(cri);
	}
	
	@Override
	public int listCount() {
		return dao.listCount();
	}
	
	@Override
	public MYBoardDto selectOne(int myno) {
		dao.boardCount(myno);
		return dao.selectOne(myno);
	}

	@Override
	public int insert(MYBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MYBoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}
	
	@Override
	public int multiDelete(String[] mynoes) {
		return dao.multiDelete(mynoes);
	}	
	
	
	@Override
	public int answerProc(MYBoardDto dto) {

		int update = dao.answerUpdate(dto.getMyno());
		int insert = dao.answerInsert(dto);

		return update + insert;
	}

	@Override
	public List<MYBoardDto> selectListPaging(int startRow, int endRow) {
		return dao.selectListPaging(startRow, endRow);
	}
	
	@Override
	public int getTotalCount() {
		return dao.getTotalCount();
	}
	
//	@Transactional // 여기를 주석처리 해 놓으면 하나만 실행해도 실행된다.
	@Override
 	public String test() {
		
		dao.insert(new MYBoardDto(0, "test", "transaction test", "transaction이 뭐였는지???", null));
	
		String test = dao.test();
		test.length();
		
		return test;
	}
	

	

}

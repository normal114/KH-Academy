package com.mvc.upgrade.model.biz;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	

	

}
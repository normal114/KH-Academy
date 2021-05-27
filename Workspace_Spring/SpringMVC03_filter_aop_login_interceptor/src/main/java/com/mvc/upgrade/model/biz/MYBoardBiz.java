package com.mvc.upgrade.model.biz;

import java.util.List;

import com.mvc.upgrade.model.dto.Criteria;
import com.mvc.upgrade.model.dto.MYBoardDto;

public interface MYBoardBiz {

	public List<MYBoardDto> selectList(Criteria cri);
	public MYBoardDto selectOne(int myno);
	public int insert(MYBoardDto dto);
	public int update(MYBoardDto dto);
	public int delete(int myno);
	public int multiDelete(String[] mynoes);
	public int listCount();
	

	public List<MYBoardDto> selectListPaging(int startRow, int endRow);
	public int getTotalCount();
	
	public int answerProc(MYBoardDto dto);
	

}

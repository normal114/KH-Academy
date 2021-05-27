package com.mvc.upgrade.model.biz;

import java.util.List;

import com.mvc.upgrade.model.dto.Criteria;
import com.mvc.upgrade.model.dto.MYBoardDto;
import com.mvc.upgrade.model.util.PagingDto;

public interface MYBoardBiz {

	public List<MYBoardDto> selectList();
	public MYBoardDto selectOne(int myno);
	public int insert(MYBoardDto dto);
	public int update(MYBoardDto dto);
	public int delete(int myno);
	public int multiDelete(String[] mynoes);
	
	public int answerProc(MYBoardDto dto);
	
	//public List<MYBoardDto> listPage(int displayPost, int postNum)
}

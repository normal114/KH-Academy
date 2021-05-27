package com.mvc.upgrade.model.dao;

import java.util.List;

import com.mvc.upgrade.model.dto.Criteria;
import com.mvc.upgrade.model.dto.MYBoardDto;
import com.mvc.upgrade.model.util.PagingDto;

public interface MYBoardDao {

	String NAMESPACE = "myboard.";
	
	public List<MYBoardDto> selectList();
	public MYBoardDto selectOne(int myno);
	public int insert(MYBoardDto dto);
	public int update(MYBoardDto dto);
	public int delete(int myno);
	public int multiDelete(String[] mynoes);
	
	public int answerUpdate(int parentBoardNo);
	public int answerInsert(MYBoardDto dto);
		
	public int count() throws Exception;
	
}

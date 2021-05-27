package com.biz;

import java.util.List;

import com.dto.MemberDto;

public interface MemberBiz {

	public List<MemberDto> selectList(); // Dao -> DB, DB -> Dao 한줄한줄 dto로 저장된다.
	public MemberDto selectOne(int m_no); // Dao -> DB, DB -> Dao 한줄만 dto
	public int insert(MemberDto dto); //
	public int update(MemberDto dto); //
	public int delete(int m_no); //
	
}
	
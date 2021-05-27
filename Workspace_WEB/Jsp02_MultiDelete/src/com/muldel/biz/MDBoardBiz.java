package com.muldel.biz;

import java.util.List;

import com.muldel.dto.MDBoardDto;

public interface MDBoardBiz {

	String SELECT_LIST_SQL = "";
	String SELECT_ONE_SQL = "";
	String INSERT_SQL = "";
	String UPDATE_SQL = "";
	String DELETE_SQL = "";
	
	public List<MDBoardDto> selectList();
	public MDBoardDto selectOne(int seq);
	public int insert(MDBoardDto dto);
	public int update(MDBoardDto dto);
	public int delete(int seq);
	
	public int multiDelete(String[] seqs);
}

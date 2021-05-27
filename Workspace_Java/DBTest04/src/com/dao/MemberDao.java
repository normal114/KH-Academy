package com.dao;

import java.util.List;

import com.dto.MemberDto;

public interface MemberDao { // 쿼리문을 틀렸을 때 쉽게 확인하기 위해서 interface에 쿼리문을 한 번에 모아서 썼다, 그리고 다형성 때문에 썼다.

	String SELECT_LIST_SQL = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL "
		     			   + " FROM TB_MEMBER "
						   + " ORDER BY M_NO DESC "; // 시퀀스 번호(M_NO)를 내림차순으로 출력한다. 
	
	String SELECT_ONE_SQL = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL "
			   	 		  + " FROM TB_MEMBER "
						  + " WHERE M_NO = ? ";
	
	String INSERT_SQL = " INSERT INTO TB_MEMBER "
					  + " VALUES(MEMBERSEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?) ";
	
	String UPDATE_SQL = " UPDATE TB_BEMBER "
					  + " SET M_NAME = ?, M_AGE = ?, M_GENDER = ?, M_LOCATION = ?, M_JOB = ?, M_TEL = ?, M_EMAIL = ? " // M_NAME, M_AGE, M_GENDER 등등을 일일히 다 써줘야 한다.
					  + " WHERE M_NO = ? ";
	
	String DELETE_SQL = " DELETE FROM TB_MEMBER "
					  + " WHERE M_NO = ? ";
	
	public List<MemberDto> selectList(); // 전체출력 해준다. 
	public MemberDto selectOne(int m_no); // primary key라서 int m_no만 잡아주었다.
	public int insert(MemberDto dto);
	public int update(MemberDto dto);
	public int delete(int m_no);
	
	
		
}

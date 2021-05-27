package com.mvc.upgrade.model.dao;

import java.util.List;

import com.mvc.upgrade.model.dto.MYMemberDto;

public interface MYMemberDao {

	String NAMESPACE = "mymember.";
	
	public MYMemberDto login(MYMemberDto dto);
	
	public List<MYMemberDto> selectAllUser();
	public List<MYMemberDto> selectEnabledUser();
	public int updateRole(int memberno, String memberrole);
	public MYMemberDto idCheck(String memberid);
	public int insertUser(MYMemberDto dto);
	public MYMemberDto selectUser(int memberno);
	public int updateUser(MYMemberDto dto);
	public int deleteUser(int memberno);

	
	
}

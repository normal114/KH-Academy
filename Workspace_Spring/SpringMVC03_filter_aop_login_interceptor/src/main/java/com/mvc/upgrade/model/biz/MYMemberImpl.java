package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.MYMemberDao;
import com.mvc.upgrade.model.dto.MYMemberDto;

@Service
public class MYMemberImpl implements MYMemberBiz {
	
	@Autowired
	private MYMemberDao dao;
	
	@Override
	public MYMemberDto login(MYMemberDto dto) {
		return dao.login(dto);
	}

	@Override
	public List<MYMemberDto> selectAllUser() {
		return dao.selectAllUser();
	}

	@Override
	public List<MYMemberDto> selectEnabledUser() {
		return dao.selectEnabledUser();
	}

	@Override
	public int updateRole(int memberno, String memberrole) {
		return dao.updateRole(memberno, memberrole);
	}

	@Override
	public MYMemberDto idCheck(String memberid) {
		return dao.idCheck(memberid);
	}

	@Override
	public int insertUser(MYMemberDto dto) {
		return dao.insertUser(dto);
	}

	@Override
	public MYMemberDto selectUser(int memberno) {
		return dao.selectUser(memberno);
	}

	@Override
	public int updateUser(MYMemberDto dto) {
		return dao.updateUser(dto);
	}

	@Override
	public int deleteUser(int memberno) {
		return dao.deleteUser(memberno);
	}

}

package com.login.biz;

import java.util.List;

import com.login.dao.MYMemberDao;
import com.login.dto.MYMemberDto;

public class MYMemberBiz {

	MYMemberDao dao = new MYMemberDao();
	
	// MYMemberDao dao;
	
	// public MYMemberBiz() {
	// dao = new MYMemberDao();
	// }

	public List<MYMemberDto> selectAllUser(){
		return dao.selectAllUser();
	}

	public List<MYMemberDto> selectEnabledUser(){
		return dao.selectEnabledUser();
	}

	public int updateRole(int myno, String myrole) {
		return dao.updateRole(myno, myrole);
	}
	

	public MYMemberDto login(String myid, String mypw) {
		return dao.login(myid, mypw);
	}

	public MYMemberDto idCheck(String myid) {
		return dao.idCheck(myid);
	}

	public int insertUser(MYMemberDto dto) {
		return 0;
	}

	public MYMemberDto selectUser(int myno) {
		return dao.selectUser(myno);
	}

	public int updateUser(MYMemberDto dto) {
		return 0;
	}

	public int deleteUser(int myno) {
		return 0;
	}
}

package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MYMemberDto;

@Repository
public class MYMemberDaoImpl implements MYMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MYMemberDto login(MYMemberDto dto) {
		
		MYMemberDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "login", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public List<MYMemberDto> selectAllUser() {
		
		List<MYMemberDto> list = new ArrayList<MYMemberDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectAllUser");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<MYMemberDto> selectEnabledUser() {
		
		List<MYMemberDto> list = new ArrayList<MYMemberDto>();
	
		try {
			list = sqlSession.selectList(NAMESPACE + "selectEnabledUser");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int updateRole(int memberno, String memberrole) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "updateRole", memberno, memberrole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public MYMemberDto idCheck(String memberid) {
		
		MYMemberDto dto = new MYMemberDto();
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "idCheck", memberid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int insertUser(MYMemberDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insertUser", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public MYMemberDto selectUser(int memberno) {
		
		MYMemberDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectUser", memberno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int updateUser(MYMemberDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "updateUser", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public int deleteUser(int memberno) {
		
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "deleteUser", memberno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
}

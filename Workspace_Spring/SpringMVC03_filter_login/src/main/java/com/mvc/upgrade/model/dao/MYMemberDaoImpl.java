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
	
}

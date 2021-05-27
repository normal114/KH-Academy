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
}

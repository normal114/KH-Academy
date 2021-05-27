package com.biz;

import java.util.List;

import com.dao.MemberDaoImpl;
import com.dao.MemberDao;
import com.dto.MemberDto;

public class MemberBizImpl implements MemberBiz {

	private MemberDao dao = new MemberDaoImpl();
	
	@Override
	public List<MemberDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MemberDto selectOne(int m_no) {
		return dao.selectOne(m_no);
	}

	@Override
	public int insert(MemberDto dto) { // MemberDto dto변수를 가져와서 toUpperCase로 바꾸고 upperGender로 넣어준다.
		// M_GENDER의 들어있는 값을 대문자로 바꾸자.
		// dto.setM_gender(dto.getM_gender().toUpperCase());
		String upperGender = dto.getM_gender().toUpperCase();
		dto.setM_gender(upperGender);
		// V -> Controller -> Biz -> Dao -> DataBase -> Dao -> Biz -> Controller -> V 순으로 진행된다.
		// Biz와 Dao(Model)은 연산 / 처리하는 과정인데 이곳에서 소문자를 대문자로 바꿔주는 연산 / 처리를 하는 것이다. 연산 / 처리하는 작업은 Biz에서 담당한다.
		// Biz는 Service Layer이다. 
		
		return dao.insert(dto); // 여기서 수정되고 dao로 간다.
	}
	
	@Override
	public int update(MemberDto dto) {		
		
		dto.setM_gender(dto.getM_gender().toUpperCase()); // 이 부분 한 번 살펴볼 것
		
		return dao.update(dto);
	}

	@Override
	public int delete(int m_no) {
		return dao.delete(m_no);
	}
}

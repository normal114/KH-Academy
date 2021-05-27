package com.biz;

import java.util.List;

import com.dao.MYTestDao;
import com.dto.MYTestDto;

// Biz : Business Logic -> 연산 / 처리. 지금 할 내용은 없는데 일부로 만들어 놓는 이유는 
// Model -> Biz(연산 / 처리하는 것) + Dao(DB랑 연결하는 것)묶이기 때문 (Dto로 연결해서 Model로 묶는 사람도 있다)
public class MYTestBiz {

	private MYTestDao dao = new MYTestDao();
	
	public List<MYTestDto> selectList() {
		return dao.selectList();
	}
	
	public int insert(MYTestDto dto) {
		return dao.insert(dto);
	}

	public MYTestDto selectOne(int mno) {
		return dao.selectOne(mno);
	}
	
	public int update(MYTestDto dto) {
		return dao.update(dto);
	}
	
	public int delete(int mno) {
		return dao.delete(mno);
	}
}
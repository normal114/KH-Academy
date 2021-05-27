package com.controller;

import java.util.List;
import java.util.Scanner;

import com.biz.MemberBiz;
import com.biz.MemberBizImpl;
import com.dto.MemberDto;

public class MemberController {

	private static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		int select = 0;
		
		StringBuffer sb = new StringBuffer();
		sb.append("**********\n")
		  .append("*1.전체출력*\n")
		  .append("*2.선택출력*\n")
		  .append("*3.추   가*\n")
		  .append("*4.수   정*\n")
		  .append("*5.삭   제*\n")
		  .append("*6.종   료*\n")
		  .append("**********\n")
		  .append("input select : ");
		System.out.println(sb);
		select = sc.nextInt();
		
		return select;
	}

	public static void main(String[] args) {
		int select = 0;
		MemberBiz biz = new MemberBizImpl();
		
		while (select != 6) {
			select = getMenu();
			
			switch (select) {
			case 1:
				List<MemberDto> selectList = biz.selectList();
				for (MemberDto dto : selectList) {
					System.out.println(dto);
				}
				
				break;
			case 2: // m_no -> C -> B -> P -> DB(table)
				System.out.println("출력할 번호 : ");
				int selectM_no = sc.nextInt();
				MemberDto selectOne = biz.selectOne(selectM_no); // selectM_no -> Biz -> Dao -> Biz -> selectM_no
				System.out.println(selectOne); // MemberDto에 toString을 Override 해놓았기 때문에 selectOne에 toString 내용이 출력된다.

				break;
			case 3: // 시퀀스(자동번호생성)로 번호(M_no)를 미리 생성해두었기 때문에 M_no를 쓰지 않는다. 
				System.out.println("추가할 이름 : ");
				String insertName = sc.next();
				System.out.println("추가할 나이 : ");
				int insertAge = sc.nextInt();
				System.out.println("추가할 성별 (M or F) : ");
				String insertGender = sc.next();
				System.out.println("추가할 위치 : ");
				String insertLocation = sc.next();
				System.out.println("추가할 직업 : ");
				String insertJob = sc.next();
				System.out.println("추가할 전화번호 : ");
				String insertTel = sc.next();
				System.out.println("추가할 이메일 : ");
				String insertEmail = sc.next(); // 이 내용을 dto에 담는다.
				// 시퀀스를 이용하여 생성하였기 때문에 자동으로 m_no가 생성된다. 따라서 inserNo는 0으로 넣어줘도 된다. 
				MemberDto insertDto = new MemberDto(0, insertName, insertAge, insertGender, insertLocation, insertJob, insertTel, insertEmail);
				int insertRes = biz.insert(insertDto);
				if (insertRes > 0) {
					System.out.println("추가 성공");
				} else {
					System.out.println("추가 실패");
				}
				
				break;
			case 4:
				System.out.println("수정할 번호 : ");
				int updateNo = sc.nextInt();
				System.out.println("수정할 이름 : ");
				String updateName = sc.next();
				System.out.println("수정할 나이 : ");
				int updateAge = sc.nextInt();
				System.out.println("수정할 성별 (M or F) : ");
				String updateGender = sc.next();
				System.out.println("추가할 위치 : ");
				String updateLocation = sc.next();
				System.out.println("추가할 직업 : ");
				String updateJob = sc.next();
				System.out.println("추가할 전화번호 : ");
				String updateTel = sc.next();
				System.out.println("추가할 이메일 : ");
				String updateEmail = sc.next();
				
				MemberDto updateDto = new MemberDto(updateNo, updateName, updateAge, updateGender, updateLocation, updateJob, updateTel, updateEmail);
				
				int updateRes = biz.update(updateDto);
				if (updateRes > 0) {
					System.out.println("수정 성공");
				} else {
					System.out.println("수정 실패");
				}
				
				break;
				
			case 5: // Controller -> Biz -> Dao -> DataBase 순으로 삭제 요청. Dao와 DataBase 사이에 DELETE FROM TB_MEMBER WERHE M_NO = ?를 명령해준다.
				System.out.println("삭제할 번호 : ");
				int deleteNo = sc.nextInt();
				int deleteRes = biz.delete(deleteNo);
				if (deleteRes > 0) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}
				
				break;
			case 6:
				break;
			}
		}
		System.out.println("프로그램 종료...");
	}
}
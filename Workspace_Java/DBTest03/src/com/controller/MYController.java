package com.controller;

import java.util.List;
import java.util.Scanner;

import com.biz.MYTestBiz;
import com.dto.MYTestDto;

public class MYController {

	private static Scanner sc = new Scanner(System.in);
	
	// view
	public static int getMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("1.전체출력\n")
		  .append("2.선택출력\n")
		  .append("3.추   가\n")
		  .append("4.수   정\n")
		  .append("5.삭   제\n")
		  .append("6.종   료\n")
		  .append("input select : ");
		System.out.println(sb);
		int select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
	
		int select = 0;
		MYTestBiz biz = new MYTestBiz();
		
		do {
			select = getMenu();
			
			switch(select) {
			case 1:
				// 전체출력
				List<MYTestDto> list = biz.selectList();
				
				for (MYTestDto dto : list) {
					System.out.printf("%3d %10s %10s\n", dto.getMno(), dto.getMname(), dto.getNickname());
				} 
				break;
			case 2:
				// 선택출력
				System.out.println("선택할 번호 : ");
				int selectOneNo = sc.nextInt();
				MYTestDto selectOneDto = biz.selectOne(selectOneNo); // biz.selectOne에서 한 줄 가져온다.
				
				System.out.printf("%3d %10s %10s\n", selectOneDto.getMno(), selectOneDto.getMname(), selectOneDto.getNickname());
				
				break;
			case 3:
				// 추가
				System.out.println("추가할 번호 : ");
				int insertNo = sc.nextInt();
				System.out.println("추가할 이름 : ");
				String insertName = sc.next();
				System.out.println("추가할 별명 : ");
				String insertNickname = sc.next(); // 여기서 추가할 번호, 추가할 이름, 추가할 별명을 입력하면 biz로 넘어가고 biz에서 dao로 넘어간다. Dao에서 다시 biz로 리턴되고 biz에서 다시 여기로 리턴된다.
				
				MYTestDto insertDto = new MYTestDto(); // dto는 버스 같은 역할을 한다. 내가 전달하고자 하는 값을 저장하는 버스.
				insertDto.setMno(insertNo);
				insertDto.setMname(insertName);
				insertDto.setNickname(insertNickname);
				
				int insertRes = biz.insert(insertDto); 
				if (insertRes > 0) {
					System.out.println("추가 성공");
				} else {
					System.out.println("추가 실패");
				}
				
				break;
			case 4:
				// 수정
				System.out.println("수정할 번호 : ");
				int updateNo = sc.nextInt();
				System.out.println("수정할 이름 : ");
				String updateName = sc.next();
				System.out.println("수정할 별명 : ");
				String updateNickname = sc.next();
				MYTestDto updateDto = new MYTestDto(updateNo, updateName, updateNickname);
				
				int updateRes = biz.update(updateDto);
				if (updateRes > 0) {
					System.out.println("수정 성공");
				} else {
					System.out.println("수정 실패");
					
				}
				
				break;
			case 5:
				// 삭제
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
				System.out.println("프로그램이 종료되었습니다...");
			}
			
		} while (select != 6);
	}
}


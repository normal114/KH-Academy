package com.cal.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cal.dto.CalDto;

public class Util {
	
	private String todates;
	
	public String getTodates() {
		return todates;
	}
	public void setTodates(String mdate) {
		// yyyy-MM-dd hh:mm:00 형태로 바꾸자.
		String temp = mdate.substring(0, 4)+"-"
					+ mdate.substring(4, 6)+"-"
					+ mdate.substring(6, 8)+" "
					+ mdate.substring(8, 10)+":"
					+ mdate.substring(10)+":00";
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분"); // SimpleDateFormat은 시간을 원하는 방식으로 포멧해준다.
		Timestamp tm = Timestamp.valueOf(temp); // timestamp는 yyyy-mm-dd : : 00형식을 지켜야 함.
		todates = sdf.format(tm); 
	}
	
	
	
	// 토요일, 일요일, 평일 색상
	public static String fontColor(int date, int dayOfWeek) {
		String color = "";
		
		if ((dayOfWeek -1 + date)%7 == 0) { // 토요일이 된다.
			color = "blue";
		} else if ((dayOfWeek -1 + date)%7 == 1) { // 일요일이 된다.
			color = "red";
		} else { // 평일
			color = "black";
		}
		
		return color;
	}
	
	// 일정의 한 자리 수 -> 두 자리 수 변환 (2021 1 1 1 1 1 를 2021 01 01 01 01 01처럼)
	public static String isTwo(String msg) {
		return (msg.length()<2)? "0"+msg : msg;
	}
	
	// 일정 제목이 긴 경우, 뒷부분을 ...으로 
	public static String getCalView(int i, List<CalDto> list) {
		
		String d = isTwo(i+"");
		String res = "";
		
		for (CalDto dto : list) {
			if (dto.getMdate().substring(6, 8).equals(d)) {
				res += "<p>"
					 + ((dto.getTitle().length() > 6)? dto.getTitle().substring(0, 6)+"..." : dto.getTitle()) // 3항 연산자 6글자 이상이면 ...으로 처리 아니면 그냥 text
					 + "</p>";
				
			}
		}
		
		return res;
	}
}

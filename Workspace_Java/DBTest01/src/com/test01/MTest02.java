package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest02 {

	// DEPT 테이블에 있는 모든 값을 출력해보자.
	public static void main(String[] args) {
		
		try {
			selectList();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void selectList() throws ClassNotFoundException, SQLException {
		
		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");  // 일단 throw하자.
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "oracle"; 
		
		Connection con = DriverManager.getConnection(url, user, password); // 이것도 import(java.sql)로 잡고 getConnection은 throw하자.
		
		// 3. query 준비
		String sql = " SELECT DEPTNO, DNAME, LOC " + " FROM DEPT "; // LOC 뒤랑 FROM 앞의 공백이 없으면 LOCFROM으로 붙어서 출력된다. 왜냐하면 코드가 길어지면 엔터 칠 상황이 많기 때문이다.
		Statement stmt = con.createStatement();
		
		// 4. query 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt("DEPTNO") + " \t " + rs.getString(2) + " \t " + rs.getString(3));
		}
		
		// 5. db 종료
		rs.close();
		stmt.close();
		con.close();
	}
}

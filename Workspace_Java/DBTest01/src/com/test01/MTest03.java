package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest03 {

	// DEPTNO를 입력받아서, 부서테이블의 해당 부서 모든 정보 출력
	// SELECt DEPTNO DNAME LOC
	// FROM DEPT
	// WHERE DEPTNO = ??
	public static void main(String[] args) {
	
		try {
			
			selectOne();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	public static void selectOne() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호를 입력하세요 : ");
		int deptno = sc.nextInt();
		
		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");  // 일단 throw하자.
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "oracle"; 
		
		Connection con = DriverManager.getConnection(url, user, password); // 이것도 import(java.sql)로 잡고 getConnection은 throw하자.
		
		// 3. query 준비
		String sql = " SELECT DEPTNO, DNAME, LOC " 
		+ " FROM DEPT "
		+ " WHERE DEPTNO = " + deptno;
		
		Statement stmt = con.createStatement(); // Statement는 테이블을 보낼 준비를 한다. 쿼리 말고 이 코드도 까먹지 않도록 주의한다.

		// 4. query 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql); // ResultSet은 DB로 Java테이블을 보낸다. 위에 deptno지우고 이 열의 sql대신 deptno를 써도 되지만 복잡해진다.
		// stmt의 executeQuery 메소드가 테이블을 DB보내면 값을 리턴한다.
		
		while (rs.next()) { // 한줄인데 왜 while을 써야 하는가? 테이블의 한 줄을 가져오지 못하기 때문 에러가 난다. 그래서 반드시 rs.next를 해야 한다. 눈에 보이진 않지만 줄이 돌다가 더이상 값이 없으면 false가 되어서 명령이 끝난다.
			System.out.println("-------------------------");
			System.out.printf("%3d %7s %7s \n", rs.getInt(1), rs.getString(2), rs.getString(3)); // 첫 번쨰 컬럼(1), 두 번째 컬럼(2), 세 번째 컬럼(3)의 값을 가져오겠다.
			// rs.getInt("DEPTNO"), rs.getString("DNAME"), rs.getString("LOC")
			// System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3));
			System.out.println("-------------------------");
		}
		
		// 5. db 종료
		rs.close();
		stmt.close();
		con.close(); // close를 순서대로 안하면 오류가 난다.
	}
}
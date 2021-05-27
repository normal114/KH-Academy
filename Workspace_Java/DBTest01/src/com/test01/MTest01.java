package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// ojdbc6.jar (*******꼭! 추가해야 한다!!) -> oracle.jdbc.driver.OracleDriver
		
		// 1. driver 연결 orcle.jdbc.driver.OracleDriver 클래스를 현재 클래스에서 사용하고 싶어요.
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 이 명령이 Java랑 DB를 연결한다.
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "oracle";
		
		
		// sql로 설정할 
		Connection con = DriverManager.getConnection(url, user, password); // Java의 코드와 데이터 베이스 사이의 통로를 만들어준다.
		
		// 3. query 준비
		String sql = " SELECT * FROM EMP ";  // SELECT 앞에 공백, EMP 뒤에 공백은 필수이다. 무조건 공백이다.
		Statement stmt = con.createStatement(); 
		
		// 4. query 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {   // 한 줄씩 가져온다 hasnNext라 생각하자.
			System.out.printf("%5d %11s %9s %5d %10s %8.2f %8.2f %2d \n", 
					rs.getInt(1), rs.getString(2), rs.getString("JOB"), rs.getInt(4), 
					rs.getDate(5), rs.getDouble("SAL"), rs.getDouble(7), rs.getInt(8) ); 
			// 숫자가 헷갈리면 이름으로 넣어도 된다. getInt(SAL) getString("ENAME") 등등
		}
		
		
		// 5. db 종료
		rs.close();
		stmt.close();
		con.close();
	}
}
		
		// 순서는 반드시 외울 것

package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// DB연결, 연결해제, 저장(commit), 취소(rollback) Class를 만든다. 1. driver연결이랑 2. 계정 연결 같은 내용을 한 번에 묶고 나중에 에러처리를 하지 않기 위해서 만드는 것이다. 
// method를 static으로 만들자. 
// nonstatic으로 만들면 계속 객체가 늘어난다. 하지만 싱글톤으로 만들면 객체를 한 번만 만들 수 있다.

public class JDBCTemplate {

	public static Connection getConnection() {
		// 1.
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "oracle";
		Connection con = null;
		
		try {
		con = DriverManager.getConnection(url, user, password);
		con.setAutoCommit(false); // MTestDao에 comit(con);을 썼는데 자동으로 커밋되는 게 아니라 res > 0 이 되었을 때(insert가 되었을 때, 적용된 row가 있다) 커밋을 하기 위해서
		// 즉, 내가 commit를 하고 싶을 때 하기 위해서 setAutoCommit(false)를 한 것이다. Autocommit이 false가 되어 있으면 commit를 하지 않으면 저장되지 않는다. 만약 이 명령이 없으면 그냥 commit된다(setAutocommit(true)이기 떄문에)
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

// pstm을 close않는 이유는 다형성 때문.자식 객체가 prepared를 통해 stmt로 들어가서 상속. 내용을 상속받아서 prepared한 것이 pstm
// close(Connection con), close(Statement stmt), close(ResultSet rs) 이것은 오버로드 한 것이다.
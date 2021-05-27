package com.answer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate { // Java랑 DB를 연결할 때 JDBCTemplate를 사용한다.

	public static Connection getConnection() { // 객체 생성은 heap으로 올라간다. non-Static으로 사용하면 select, insert, update, delete를 사용할 때마다 호출해야 하기 때문에 힙 영역에 JDBC가 만들어 지기 때문에 메모리 사용이 많다. static은 힙에 한 번 올라간 후에 계속 사용할 수 있기 때문에 메모리 사용이 줄어든다.
		
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. driver 연결");
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
			con.setAutoCommit(false);
			System.out.println("2. 계정 연결");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) { // Statement는 preparedStatement의 부모타입인데 부모타입으로 close한 것이다.
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		close(rs);
		close(stmt);
		close(con);
	}
	
	public static void close(Statement stmt, Connection con) {
		close(stmt);
		close(con);
	}
	
	public static void commit(Connection con) { // setAutoCommit으로 해 놓았기 때문에 내가 필요할 때 commit, rollback할 코드가 필요하다.
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


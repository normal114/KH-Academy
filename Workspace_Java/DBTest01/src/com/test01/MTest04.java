package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest04 {

	// DEPT 테이블에 값 저장
	public static void main(String[] args) {
		//insert();
		insertForPrepared();
	}
	
	public static void insertForPrepared() {
	
	Scanner sc = new Scanner (System.in);
	System.out.println("부서번호 입력 : ");
	int deptno = sc.nextInt();
	System.out.println("부서이름 입력 : ");
	String dname = sc.next();
	System.out.println("지역 입력 : ");
	String loc = sc.next();
	
	// 1. 
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// 2.
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String password = "oracle";
	Connection con = null; 
	
	try {
		con = DriverManager.getConnection(url, user, password);
		// con = setAutoCommit(false);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	// 3.
	String sql = " INSERT INTO DEPT "
			+ " VALUES (?, ?, ?) ";
	PreparedStatement pstm = null; // 아까 전에 Values값을 다 넣어서 힘들어서 ?로 바꿔주는 명령문. 훨씬 간단하고 오타가 적다.
	
	try {
		// 3. 
		pstm = con.prepareStatement(sql);
		pstm.setInt(1,  deptno);
		pstm.setString(2,  dname);
		pstm.setString(3, loc);
		
		// 4. 
		int res = pstm.executeUpdate();
		if (res > 0) {
			System.out.println("입력 성공");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		//5.
		try {
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	}
	
	public static void insert() {
		Scanner sc = new Scanner (System.in);
		System.out.println("부서번호 입력 : ");
		int deptno = sc.nextInt();
		System.out.println("부서이름 입력 : ");
		String dname = sc.next();
		System.out.println("지역 입력 : ");
		String loc = sc.next();
		
		// 1. diver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		// 2.
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // New Oracle은 이클립스에서 db에 연결하고 Coeection은 코드로 db에 연결한다.
		String user = "system";
		String password = "oracle";
		
		
		Connection con = null; 
		try {
			con = DriverManager.getConnection(url, user, password);
			// con = setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = " INSERT INTO DEPT "
					+ " VALUES( " + deptno + ", '" + dname + "', '" + loc + "') "; // 싱글쿼테이션(')에 유의할 것. dname과 loc는 문자이기 때문에 (')가 필요. 숫자는 싱글쿼테이션 생략이 가능하다.
		Statement stmt = null;
		// ResultSet rs = null;
		
		try {
			
			// 3.
			stmt = con.createStatement();
		
			//4.
			int res = stmt.executeUpdate(sql);
			if (res > 0) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

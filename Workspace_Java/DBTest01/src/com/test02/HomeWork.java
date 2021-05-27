package com.test02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HomeWork {

	static Scanner sc = new Scanner(System.in);
		
	public static void main(String[] args) {
	
		System.out.println("메뉴 선택");
		System.out.println("1:전체선택 2:특정 부서 선택 3: 부서 추가 4: 부서 수정 5: 부서 삭제 6: 종료");
		int select = sc.nextInt();
		
		switch(select) {
		case 1:
			selectList();
			break;
		case 2:
			selectOne();
			break;
		case 3:
			insert();
			break;
		case 4:
			update();
			break;
		case 5:
			delete();
			break;
		case 6:
			System.out.println("종료");
			break;
		}
		
	}


	private static void delete() {
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3.
		System.out.println("삭제할 부서 번호 :");
		int deptno = sc.nextInt();
		
		String sql = " DELETE FROM DEPT "
				   + " WHERE DEPTNO = ? ";
		
		PreparedStatement pstm = null;
		
		try {
			// 3.
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, deptno);
			
			// 4.
			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("삭제 성공");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	private static void update() {
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3.
		System.out.println("수정할 부서번호 : ");
		int deptno = sc.nextInt();
		System.out.println("수정할 부서 이름 : ");
		String dname = sc.next();
		System.out.println("수정할 부서 지역 : ");
		String loc = sc.next();
		
		String sql = " UPDATE DEPT "
				   + " SET DNAME = ? , LOC = ? "
				   + " WHERE DEPTNO = ? ";
		
		PreparedStatement pstm = null;
		
		try {
			// 3.
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dname);
			pstm.setString(2, loc);
			pstm.setInt(3, deptno);
			
			// 4.
			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("수정 성공");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void insert() {
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 3.
		System.out.println("추가할 부서번호 :");
		int deptno = sc.nextInt();
		System.out.println("추가할 부서 이름 : ");
		String dname = sc.next();
		System.out.println("추가할 부서 지역 : ");
		String loc = sc.next();
		
		String sql = " INSERT INTO DEPT "
				   + " VALUES(?, ?, ?) ";
		
		PreparedStatement pstm = null;
		
		try {
			// 3.
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, deptno);
			pstm.setString(2, dname);
			pstm.setString(3, loc);
			
			// 4.
			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("입력 성공");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	private static void selectOne() {
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3.
		System.out.println("출력할 부서번호 : ");
		
		int deptno = sc.nextInt();
		String sql = " SELECT DEPTNO, DNAME, LOC "
				   + " FROM DEPT "
				   + " WHERE DEPTNO = " + deptno;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 3.
			stmt = con.createStatement();

			// 4.
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.printf("%5d %10s %10s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	private static void selectList() {
		// 1. driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2. 계정연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. query 준비
		String sql = " SELECT DEPTNO, DNAME, LOC "
				   + " FROM DEPT ";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 3.
			stmt = con.createStatement();
			
			// 4. query 실행 및 리턴
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.printf("%5d %10s %10s\n", rs.getInt(1), rs.getString(2), rs.getString("LOC"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. db 종료
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

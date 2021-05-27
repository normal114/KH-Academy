package com.bike.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bike.dto.BikeDto;

public class BikeDao {

	public boolean insert(List<BikeDto> list) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. driver 연결");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

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
		
		String sql = " INSERT INTO KOREABIKE"
				   + " VALUES(?, ?, ?, ?, ?) ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				pstm.setString(1, list.get(i).getName());
				pstm.setString(2, list.get(i).getAddr());
				pstm.setDouble(3, list.get(i).getLatitude());
				pstm.setDouble(4, list.get(i).getLongitude());
				pstm.setInt(5, list.get(i).getBike_count());
				
				pstm.addBatch();
			}
			System.out.println("3. query 준비 : " + sql);
			
			int[] result = pstm.executeBatch();
			System.out.println("4. query 실행 및 리턴");
			for (int i = 0; i < result.length; i++) {
				if (result[i] == -2) {
					res++;
				}
			}
			
			if (res == list.size()) {
				con.commit();
			} else {
				con.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
				System.out.println("5. db 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return (res == list.size()? true : false);
	}
	
	
	public boolean delete() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. driver 연결");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

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
		
		
		String sql = " DELETE FROM KOREABIKE ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비 : " + sql);
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			if (res > 0) {
				con.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
				System.out.println("5. db 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return (res > 0)? true : false;
	}
}
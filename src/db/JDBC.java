package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC {
	public static Connection conn;
	public static Statement stmt;
	public static void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				 conn =  DriverManager.getConnection(
						"jdbc:oracle:thin:@114.71.137.174:53994:XE",
						"JAVA17","lib2017");
				  stmt = conn.createStatement();
				  System.out.println("DB 연결 성공");
			} catch (SQLException e) {
				System.out.println("JDBC 드라이버 로드 에러");
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
			System.err.println("DB 연결 오류");
			e.printStackTrace();
		}
	}
		//조회;
		public static ResultSet getResultSet(String sql) {
			try {
				Statement stmt = conn.createStatement();
				return stmt.executeQuery(sql);
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		//삽입,수정,삭제
		public static void executeQuery(String sql) {
			try {
				stmt.executeUpdate(sql);				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
	public static void main(String[] args) {
		
		try {
			//1.오라클 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 드라이버 매니저 연결
			Connection conn =  DriverManager.getConnection(
					"jdbc:oracle:thin:@114.71.137.174:53994:XE",
					"JAVA17","lib2017");
			Statement stmt = conn.createStatement();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.err.println("DB 연결 오류");
			e.printStackTrace();
		}
		
	}

}

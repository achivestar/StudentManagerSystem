package kr.pe.bluering.sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {

	static {  
		// MySQL 에서 제공하는 드라이버 클래스를 로딩
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			//MySQL 서벓 연결을 해주는 부분
			con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/java?useUnicode=true&characterEncoding=UTF-8","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	//Connection 객체를 닫아주는 메소드 정의
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Statement 객체를 닫아주는 메소드 정의
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ResultSet 객체를 닫아주는 메소드 정의
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

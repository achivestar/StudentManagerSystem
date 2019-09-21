package kr.pe.bluering.sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {

	static {  
		// MySQL ���� �����ϴ� ����̹� Ŭ������ �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			//MySQL ���� ������ ���ִ� �κ�
			con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/java?useUnicode=true&characterEncoding=UTF-8","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	//Connection ��ü�� �ݾ��ִ� �޼ҵ� ����
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Statement ��ü�� �ݾ��ִ� �޼ҵ� ����
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ResultSet ��ü�� �ݾ��ִ� �޼ҵ� ����
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

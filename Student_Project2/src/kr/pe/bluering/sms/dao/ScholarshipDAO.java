package kr.pe.bluering.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipDAO {

	Connection con;
	public ScholarshipDAO(Connection con) {
		this.con = con;
	}
	
	public Scholarship selectScholarship(String scholar_name) {
		Scholarship searchScholarship  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM scholarship WHERE scholar_name = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scholar_name);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				searchScholarship = new Scholarship(
						rs.getString("scholar_name"),
						rs.getInt("scholar_percent"),
						rs.getInt("scholar_money")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchScholarship;
	}
	
	public int insertScholarShip(Scholarship newScholarship) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO scholarship values(?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newScholarship.getScholar_name());
			pstmt.setInt(2, newScholarship.getScholar_percent());
			pstmt.setInt(3, newScholarship.getScholar_money());
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertCount;
	}

	
	public ArrayList<Scholarship> selectScholarshipList() {
		ArrayList<Scholarship> scholarshipList = null;
		Scholarship scholarship = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM scholarship";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				scholarshipList = new ArrayList<Scholarship>();
				do {
					scholarship = new Scholarship(
						rs.getString("scholar_name"),
						rs.getInt("scholar_percent"),
						rs.getInt("scholar_money"));
					scholarshipList.add(scholarship);
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return scholarshipList;
	}

	public ArrayList<Scholarship> selectScholarshipByScholar_name(String sc_name) {
		ArrayList<Scholarship> searchScholarshipList = null;
		Scholarship searchScholarship = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM scholarship WHERE scholar_name like concat('%',?,'%')";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sc_name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				searchScholarshipList = new ArrayList<Scholarship>();
				do {
					searchScholarship = new Scholarship(
							rs.getString("scholar_name"), 
							rs.getInt("scholar_percent"), 
							rs.getInt("scholar_money"));
					
					searchScholarshipList.add(searchScholarship);
				}while(rs.next());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchScholarshipList;
	}

	public ArrayList<Scholarship> selectScholarshipByScholar_money(int money) {
		ArrayList<Scholarship> searchScholarshipList = null;
		Scholarship searchScholarship = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM scholarship WHERE scholar_money = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, money);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				searchScholarshipList = new ArrayList<Scholarship>();
				do {
					searchScholarship = new Scholarship(
							rs.getString("scholar_name"), 
							rs.getInt("scholar_percent"), 
							rs.getInt("scholar_money"));
					
					searchScholarshipList.add(searchScholarship);
				}while(rs.next());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchScholarshipList;
	}

	public int updateScholarship(Scholarship changeScholarship) {
		
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE scholarship SET scholar_percent=?, scholar_money=? WHERE scholar_name=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, changeScholarship.getScholar_percent());
			pstmt.setInt(2, changeScholarship.getScholar_money());
			pstmt.setString(3, changeScholarship.getScholar_name());
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateCount;
	}

	public int deleteScholarship(String sc_name) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM scholarship WHERE scholar_name = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sc_name);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteCount;
	}
}

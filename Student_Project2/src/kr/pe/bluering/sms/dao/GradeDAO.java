package kr.pe.bluering.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.pe.bluering.sms.vo.Grade;

public class GradeDAO {

	Connection con;
	public GradeDAO(Connection con) {
		this.con = con;
	}
	public Grade selectGrade(int student_no) {
		// �Ķ���ͷ� ������ �л� ��ȣ�� ���� �л��� ������ ��ȸ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		Grade grade = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT student.student_no, student_name, grade_kor, grade_eng,"
				+ "grade_math FROM grade, student WHERE grade.student_no=student.student_no AND"
				+ " grade.student_no=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				grade = new Grade(
						rs.getInt("student_no"),
						rs.getString("student_name"),
						rs.getInt("grade_kor"),
						rs.getInt("grade_eng"),
						rs.getInt("grade_math")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grade;
	}
	
	public int insertGrade(Grade newGrade) {
		
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO grade VALUES (?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newGrade.getStudent_no());
			pstmt.setInt(2, newGrade.getGrade_kor());
			pstmt.setInt(3, newGrade.getGrade_eng());
			pstmt.setInt(4, newGrade.getGrade_math());
			
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return insertCount;
	}
	public ArrayList<Grade> selectGradeList() {
		//Grade ���̺� �����ϴ� ��� ���� ������ ��ȸ�ؼ� �����ϴ� �޼ҵ�
		ArrayList<Grade> gradeList= null;
		Grade grade = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT grade.student_no, student_name, grade_kor, grade_eng, grade_math FROM grade, student ";
		sql+= "WHERE grade.student_no = student.student_no";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				/*
				 * select ���� ���࿡ ���� ��ȯ�� ���ڵ尡 �����ϸ� ���ڵ尡 �����ϴ� ��ŭ �ݺ����� �����ϸ鼭
				 * �ϳ��� ���ڵ� �����͸� �ϳ���  Grade��ü�� �Ӽ������� �Ҵ��Ͽ�  �� Grade��ü��  
				 * ArrayList Ÿ����  gradeList��ü�� �߰��ϰ� ����
				 * */
				gradeList = new ArrayList<Grade>();
				 
				do {
					grade = new Grade(
						rs.getInt("student_no"),
						rs.getString("student_name"),
						rs.getInt("grade_kor"),
						rs.getInt("grade_eng"),
						rs.getInt("grade_math")
					);
					
					gradeList.add(grade);
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gradeList;
	}
	
	
	public ArrayList<Grade> selectGradeListByStudent_name(String student_name) {
		ArrayList<Grade> searchGradeList = null;
		Grade searchGrade = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT grade.student_no, student_name, grade_kor, grade_eng, grade_math FROM ";
		sql+="grade, student WHERE grade.student_no = student.student_no AND student_name like concat('%',?,'%')";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				searchGradeList = new ArrayList<Grade>();
				do {
					searchGrade = new Grade(
						rs.getInt("student_no"),
						rs.getString("student_name"),
						rs.getInt("grade_kor"),
						rs.getInt("grade_eng"),
						rs.getInt("grade_math")
					);
					searchGradeList.add(searchGrade);
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchGradeList;
	}
	public ArrayList<Grade> selectGradeListByStudent_no(int student_no) {
		ArrayList<Grade> searchGradeList = null;
		Grade searchGrade = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT grade.student_no, student_name, grade_kor, grade_eng, grade_math FROM ";
		sql+="grade, student WHERE grade.student_no = student.student_no AND grade.student_no like concat(?,'%')";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				searchGradeList = new ArrayList<Grade>();
				do {
					searchGrade = new Grade(
						rs.getInt("student_no"),
						rs.getString("student_name"),
						rs.getInt("grade_kor"),
						rs.getInt("grade_eng"),
						rs.getInt("grade_math")
					);
					searchGradeList.add(searchGrade);
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchGradeList;
	}
	public ArrayList<Grade> selectGradeListByStudent_year(int student_year) {
		ArrayList<Grade> searchGradeList = null;
		Grade searchGrade = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT grade.student_no, student_name, grade_kor, grade_eng, grade_math FROM ";
		sql+="grade, student WHERE grade.student_no = student.student_no AND student_year = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_year);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				searchGradeList = new ArrayList<Grade>();
				do {
					searchGrade = new Grade(
						rs.getInt("student_no"),
						rs.getString("student_name"),
						rs.getInt("grade_kor"),
						rs.getInt("grade_eng"),
						rs.getInt("grade_math")
					);
					searchGradeList.add(searchGrade);
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchGradeList;
	}
	
	
	public int updateGrade(Grade changeGrade) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE grade SET grade_kor = ?, grade_eng = ?, grade_math=? WHERE student_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, changeGrade.getGrade_kor());
			pstmt.setInt(2, changeGrade.getGrade_eng());
			pstmt.setInt(3, changeGrade.getGrade_math());
			pstmt.setInt(4, changeGrade.getStudent_no());
			
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateCount;
	}
	
	
	public int deleteGrade(int student_no) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM grade WHERE student_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_no);
			deleteCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteCount;
	}
	public ArrayList<Grade> selectGradeListAddPercent(int size) {
		float percent = 0;
		int count = 1;
		ArrayList<Grade> gradeListAddPercent = null;
		PreparedStatement pstmt = null;
		Grade grade = null;
		ResultSet rs = null;
		String sql = "SELECT grade.student_no, student_name, grade_kor, grade_eng, grade_math FROM grade, student ";
		sql+= "WHERE grade.student_no = student.student_no ORDER BY (grade_kor+grade_eng+grade_math) DESC";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				gradeListAddPercent = new ArrayList<Grade>();
				
				do {
					percent = count++ / (float)size * 100;
					grade = new Grade(
							rs.getInt("student_no"),
							rs.getString("student_name"),
							rs.getInt("grade_kor"),
							rs.getInt("grade_eng"),
							rs.getInt("grade_math"),
							percent
					);
					
					gradeListAddPercent.add(grade);
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gradeListAddPercent;
	}
}

package kr.pe.bluering.sms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.pe.bluering.sms.vo.Student;

public class StudentDAO {

	Connection con;
	public StudentDAO(Connection con) {
		this.con = con;
	}

	public Student selectStudent(int stu_no) {
		Student student = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM student WHERE student_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stu_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				student = new Student(
						rs.getInt("student_no"),
						rs.getString("student_name"),
						rs.getInt("student_year"),
						rs.getString("student_addr"),
						rs.getString("student_tel"),
						rs.getDate("student_birth").toString()
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return student;
	}

	public int insertStudent(Student newStudent, Date birth) {
		
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO student VALUES (?,?,?,?,?,?);";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newStudent.getStudent_no());
			pstmt.setString(2, newStudent.getStudent_name());
			pstmt.setInt(3, newStudent.getStudent_year());
			pstmt.setString(4, newStudent.getStudent_addr());
			pstmt.setString(5, newStudent.getStudent_tel());
			pstmt.setDate(6, birth);
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertCount;
		
	}

	public ArrayList<Student> selectStudentList() {
		ArrayList<Student> studentList = null;
		Student student = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				studentList = new ArrayList<Student>();
				
				do {
					student = new Student(
					 rs.getInt("student_no"),
					 rs.getString("student_name"),
					 rs.getInt("student_year"),
					 rs.getString("student_addr"),
					 rs.getString("student_tel"),
					 rs.getDate("student_birth").toString()
				     );
					studentList.add(student);
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public int updateStudent(Student changeStudent) {
		
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE student SET student_name=?, student_year=?, student_addr=?, student_tel=? WHERE student_no=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, changeStudent.getStudent_name());
			pstmt.setInt(2, changeStudent.getStudent_year());
			pstmt.setString(3, changeStudent.getStudent_addr());
			pstmt.setString(4, changeStudent.getStudent_tel());
			pstmt.setInt(5, changeStudent.getStudent_no());
			
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateCount;
	}

	public int deleteStudent(int stu_no) {
		// �Ķ���ͷ� ���۵� stu_no ���� ������ �ִ� �л��� ������  student ���̺��� ����
		// �ϴ� �޼ҵ�..  Student ���̺�ּ� �ش� �л� ������ �����ϱ� ���� �ش� �л� ������
		// �����ϰ� �ִ�   grade ���̺��� ���������� ���� �����Ѵ�.
		// Student���� ���������� ��ϵǱ� �����ε�   student ���̺����� �л������� �����ϸ�
		// grade ���̺��� ���� ���� �ʴ� �л��� ������ ����Ǿ� �ִ� ����� �Ǳ� �����̴�.
		
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM grade WHERE student_no=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stu_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String sql_stu = "DELETE FROM student WHERE student_no=?";
		
		try {
			pstmt = con.prepareStatement(sql_stu);
			pstmt.setInt(1, stu_no);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteCount;
	}

	public ArrayList<Student> selectStudentListByStudent_name(String stu_name) {
		ArrayList<Student> searchStudentList = new ArrayList<Student>();
		Student searchStudent = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE student_name like concat('%',?,'%')";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				do {
					searchStudent = new Student(
						rs.getInt("student_no"),
						rs.getString("student_name"),
						rs.getInt("student_year"),
						rs.getString("student_addr"),
						rs.getString("student_tel"),
						rs.getDate("student_birth").toString()
					);
					searchStudentList.add(searchStudent);
				}while(rs.next());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return searchStudentList;
	}

	public ArrayList<Student> selectStudentListByStudent_no(int stu_no) {
		ArrayList<Student> searchStudentList = new ArrayList<Student>();
		Student searchStudent = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE student_no like concat(?,'%')";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stu_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				do {
					searchStudent = new Student(
						rs.getInt("student_no"),
						rs.getString("student_name"),
						rs.getInt("student_year"),
						rs.getString("student_addr"),
						rs.getString("student_tel"),
						rs.getDate("student_birth").toString()
					);
					searchStudentList.add(searchStudent);
				}while(rs.next());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return searchStudentList;
	}

	public ArrayList<Student> selectStudentListByStudent_year(int student_year) {
		ArrayList<Student> searchStudentList = new ArrayList<Student>();
		Student searchStudent = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE student_year = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_year);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				do {
					searchStudent = new Student(
						rs.getInt("student_no"),
						rs.getString("student_name"),
						rs.getInt("student_year"),
						rs.getString("student_addr"),
						rs.getString("student_tel"),
						rs.getDate("student_birth").toString()
					);
					searchStudentList.add(searchStudent);
				}while(rs.next());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return searchStudentList;
	}

}

package kr.pe.bluering.sms.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.pe.bluering.sms.dao.StudentDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Student;

public class StudentSearchService {

	public ArrayList<Student> getSearchStudentListByStudent_name(String stu_name) {
		Connection con = JdbcUtil.getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		ArrayList<Student> searchStudentList = studentDAO.selectStudentListByStudent_name(stu_name);
		JdbcUtil.close(con);
		return searchStudentList;
	}

	public ArrayList<Student> getSearchStudentListByStudent_no(int stu_no) {
		Connection con = JdbcUtil.getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		ArrayList<Student> searchStudentList = studentDAO.selectStudentListByStudent_no(stu_no);
		JdbcUtil.close(con);
		return searchStudentList;
	}

	public ArrayList<Student> getSearchStudentListByStudent_year(int student_year) {
		Connection con = JdbcUtil.getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		ArrayList<Student> searchStudentList = studentDAO.selectStudentListByStudent_year(student_year);
		JdbcUtil.close(con);
		return searchStudentList;
	}

}

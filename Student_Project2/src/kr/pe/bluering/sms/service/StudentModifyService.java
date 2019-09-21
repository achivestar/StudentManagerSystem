package kr.pe.bluering.sms.service;

import java.sql.Connection;

import kr.pe.bluering.sms.dao.StudentDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Student;

public class StudentModifyService {

	public Student getModifyStudent(int stu_no) {
		
		Connection con = JdbcUtil.getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		Student modifyStudent = studentDAO.selectStudent(stu_no);
		JdbcUtil.close(con);
		
		return modifyStudent;
	}

	public static boolean modifyStudent(Student changeStudent) {
		
		boolean isModifySuccess = false;
		Connection con = JdbcUtil.getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		
		int updateCount = studentDAO.updateStudent(changeStudent);
		
		if(updateCount>0) {
			isModifySuccess = true;
		}else {
			isModifySuccess = false;
		}
		
		return isModifySuccess;
	}

	

}

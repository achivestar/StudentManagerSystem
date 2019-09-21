package kr.pe.bluering.sms.service;

import java.sql.Connection;

import kr.pe.bluering.sms.dao.StudentDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Student;

public class StudentDeleteService {

	public static Student getDeleteStudent(int stu_no) {
		Connection con = JdbcUtil.getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		Student deleteStudent = studentDAO.selectStudent(stu_no);
		JdbcUtil.close(con);
		return deleteStudent;
	}

	public boolean deleteStudent(int stu_no) {
		boolean isDeleteSuccess = false;
		Connection con = JdbcUtil.getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		int deleteCount = studentDAO.deleteStudent(stu_no);
		
		if(deleteCount > 0) {
			isDeleteSuccess = true;
		}else {
			isDeleteSuccess = false;
		}
		return isDeleteSuccess;
	}

}

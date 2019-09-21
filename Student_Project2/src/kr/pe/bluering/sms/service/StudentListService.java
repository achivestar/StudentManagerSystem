package kr.pe.bluering.sms.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.pe.bluering.sms.dao.StudentDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.*;

public class StudentListService {

	public ArrayList<Student> getStudentList() {
		
		Connection con = JdbcUtil.getConnection();
		StudentDAO memberDAO = new StudentDAO(con);
		ArrayList<Student> studentList = memberDAO.selectStudentList();
		JdbcUtil.close(con);
		
		return studentList;
	}


}

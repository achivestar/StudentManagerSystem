package kr.pe.bluering.sms.service;

import java.sql.Connection;

import kr.pe.bluering.sms.dao.GradeDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Grade;

public class GradeDeleteService {

	public Grade getDeleteScore(int student_no) {
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		Grade deleteGrade = gradeDAO.selectGrade(student_no);
		JdbcUtil.close(con);
		return deleteGrade;
	}

	public boolean deleteGrade(int student_no) {
		boolean isDeleteSuccess = false;
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		int deleteCount = gradeDAO.deleteGrade(student_no);
		
		if(deleteCount>0) {
			isDeleteSuccess = true;
		}else {
			isDeleteSuccess = false;
		}
		return isDeleteSuccess;
	}

}

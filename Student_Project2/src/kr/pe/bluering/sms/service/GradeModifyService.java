package kr.pe.bluering.sms.service;

import java.sql.Connection;

import kr.pe.bluering.sms.dao.GradeDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Grade;

public class GradeModifyService {

	public Grade getModifyGrade(int student_no) {
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		Grade modifyGrade = gradeDAO.selectGrade(student_no);
		JdbcUtil.close(con);
		return modifyGrade;
	}

	public boolean modifyGrade(Grade changeGrade) {
		
		boolean isModifySuccess =  false;
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		int updateCount = gradeDAO.updateGrade(changeGrade);
		
		if(updateCount>0) {
			isModifySuccess = true;
		}else {
			isModifySuccess = false;
		}
		return isModifySuccess;
	}

}

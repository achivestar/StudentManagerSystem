package kr.pe.bluering.sms.service;

import java.sql.Connection;

import kr.pe.bluering.sms.dao.ScholarshipDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipDeleteService {

	public Scholarship getDeleteScholarship(String sc_name) {
		Connection con = JdbcUtil.getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		Scholarship deleteScholarship = scholarshipDAO.selectScholarship(sc_name);
		JdbcUtil.close(con);
		return deleteScholarship;
	}

	public boolean deleteScore(String sc_name) {
		boolean isDeleteSuccess = false;
		Connection con = JdbcUtil.getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		int deleteCount = scholarshipDAO.deleteScholarship(sc_name);
		
		if(deleteCount>0) {
			isDeleteSuccess = true;
		}else {
			isDeleteSuccess = false;
		}
		return isDeleteSuccess;
	}

}

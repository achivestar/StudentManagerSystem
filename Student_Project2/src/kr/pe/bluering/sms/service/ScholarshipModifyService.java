package kr.pe.bluering.sms.service;

import java.sql.Connection;

import kr.pe.bluering.sms.dao.ScholarshipDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipModifyService {

	public Scholarship getModifyScholarship(String sc_name) {
		Connection con = JdbcUtil.getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		Scholarship modifyScholarship = scholarshipDAO.selectScholarship(sc_name);
		JdbcUtil.close(con);
		return modifyScholarship;
	}

	public boolean modifyScholarship(Scholarship changeScholarship) {
		Connection con = JdbcUtil.getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		boolean isModifySuccess = false;
		int updateCount = scholarshipDAO.updateScholarship(changeScholarship);
		
		if(updateCount>0) {
			isModifySuccess = true;
		}else {
			isModifySuccess = false;
		}
		return isModifySuccess;
	}

}

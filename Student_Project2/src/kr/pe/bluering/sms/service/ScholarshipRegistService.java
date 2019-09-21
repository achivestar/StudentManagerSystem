package kr.pe.bluering.sms.service;

import java.sql.Connection;

import kr.pe.bluering.sms.dao.ScholarshipDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipRegistService {

	public boolean searchScholarship(String sc_name) {
		boolean isRegisted =  false;
		Connection con = JdbcUtil.getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		Scholarship searchScholarship = scholarshipDAO.selectScholarship(sc_name);
		
		if(searchScholarship != null) {
			isRegisted = true;
		}
		
		JdbcUtil.close(con);
		return isRegisted;
	}

	public boolean registScholarship(Scholarship newScholarship) {
		boolean isRegistSuccess = false;
		Connection con = JdbcUtil.getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		int insertcount = scholarshipDAO.insertScholarShip(newScholarship);
		
		if(insertcount>0) {
			isRegistSuccess = true;
		}else {
			isRegistSuccess = false;
		}
		return isRegistSuccess;
	}

}

package kr.pe.bluering.sms.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.pe.bluering.sms.dao.ScholarshipDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipListService {

	public ArrayList<Scholarship> getScholarshipList() {
		
		Connection con = JdbcUtil.getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		
		ArrayList<Scholarship> scholarshipList = scholarshipDAO.selectScholarshipList();
		JdbcUtil.close(con);
		return scholarshipList;
	}

}

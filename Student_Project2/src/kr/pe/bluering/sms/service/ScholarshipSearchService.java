package kr.pe.bluering.sms.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.pe.bluering.sms.dao.ScholarshipDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipSearchService {

	public ArrayList<Scholarship> getSearchScholarshipListBySc_name(String sc_name) {
		Connection con = JdbcUtil.getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		ArrayList<Scholarship> searchScholarshipList = scholarshipDAO.selectScholarshipByScholar_name(sc_name);
		JdbcUtil.close(con);
		return searchScholarshipList;
	}

	public ArrayList<Scholarship> getSearchScholarshipListByMoney(int money) {
		Connection con = JdbcUtil.getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		ArrayList<Scholarship> searchScholarshipList = scholarshipDAO.selectScholarshipByScholar_money(money);
		JdbcUtil.close(con);
		return searchScholarshipList;
	}

}

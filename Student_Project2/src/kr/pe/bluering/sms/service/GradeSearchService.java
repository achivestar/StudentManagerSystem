package kr.pe.bluering.sms.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.pe.bluering.sms.dao.GradeDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Grade;

public class GradeSearchService {

	// 인자로 던져주는 학생의 이름으로 등록되어 있는 성적정보를  ArrayList<Grade> 타입으로 반환
	public ArrayList<Grade> getSearchGradeListByStudent_name(String student_name) {
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		ArrayList<Grade> searchGradeList = gradeDAO.selectGradeListByStudent_name(student_name);
		JdbcUtil.close(con);
		return searchGradeList;
	}

	// 인자로 던져주는 학생의 번호로 등록되어 있는 성적정보를  ArrayList<Grade> 타입으로 반환
	public ArrayList<Grade> getSearchGradeListByStudent_no(int student_no) {
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		ArrayList<Grade> searchGradeList = gradeDAO.selectGradeListByStudent_no(student_no);
		JdbcUtil.close(con);
		return searchGradeList;
	}

	// 인자로 던져주는 학생의 학년으로 등록되어 있는 성적정보를  ArrayList<Grade> 타입으로 반환
	public ArrayList<Grade> getSearchGradeListByStudent_year(int student_year) {
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		ArrayList<Grade> searchGradeList = gradeDAO.selectGradeListByStudent_year(student_year);
		JdbcUtil.close(con);
		return searchGradeList;
	}

}

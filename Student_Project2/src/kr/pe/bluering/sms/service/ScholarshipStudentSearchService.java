package kr.pe.bluering.sms.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.pe.bluering.sms.dao.GradeDAO;
import kr.pe.bluering.sms.dao.ScholarshipDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Grade;
import kr.pe.bluering.sms.vo.Scholarship;
import kr.pe.bluering.sms.vo.ScholarshipStudent;

public class ScholarshipStudentSearchService {

	public Scholarship getSearchScholarship(String sc_name) {
		Connection con = JdbcUtil.getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		Scholarship searchScholarship = scholarshipDAO.selectScholarship(sc_name);
		JdbcUtil.close(con);
		return searchScholarship;
	}

	public ArrayList<Grade> getScoreListAddPercent() {
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		
		ArrayList<Grade> gradeList = gradeDAO.selectGradeList(); 
		//학생들의 전체 성적 정보 목록을 얻어온다.
		
		ArrayList<Grade> gradeListAddPercent = gradeDAO.selectGradeListAddPercent(gradeList.size());
		/*
		 * 학생들의 전체 성적정보 목록에 해당 학생 성적의 전체 학생 성적에서의 백분율을 추가한 성적 목록을 얻어온다.
		 * 즉, 학생 성적 정보에 백분율(%) 값도 포함된  Grade  목록이 얻어와진다.
		 * */
		
		JdbcUtil.close(con);
		return gradeListAddPercent;
	}

	public ArrayList<ScholarshipStudent> getSholarshipStudentSearchList(Scholarship searchScholarship,
			ArrayList<Grade> scoreListAddPercent) {
		
		ArrayList<ScholarshipStudent> searchScholarshipStudentList = new ArrayList<ScholarshipStudent>();
		ScholarshipStudent scholarshipStudent = null;
		
		for(int i=0; i<scoreListAddPercent.size()-1;i++) {
			if(scoreListAddPercent.get(i).getAvg() == scoreListAddPercent.get(i+1).getAvg()) {
				scoreListAddPercent.get(i+1).setPercent(scoreListAddPercent.get(i).getPercent());
			}
		}
		
		for(int i=0; i<scoreListAddPercent.size();i++) {
			if(scoreListAddPercent.get(i).getPercent() <= searchScholarship.getScholar_percent()) {
				// 검색 대상 장학금종류의 백분율 보다 작거나 같은 백분율을 가진 성적들의 정보를 ScholarshipStudent 객체에 저장하여
				// searchScholarshipStudentList에 추가
				scholarshipStudent = new ScholarshipStudent(
					scoreListAddPercent.get(i).getStudent_no(),
					scoreListAddPercent.get(i).getStudent_name(),
					scoreListAddPercent.get(i).getAvg(),
					searchScholarship.getScholar_name(),
					scoreListAddPercent.get(i).getPercent(),
					searchScholarship.getScholar_money()
				);
				
				searchScholarshipStudentList.add(scholarshipStudent);
			}
		}
		return searchScholarshipStudentList;
	}

}

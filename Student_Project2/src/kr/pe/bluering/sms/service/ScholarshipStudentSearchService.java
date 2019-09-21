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
		//�л����� ��ü ���� ���� ����� ���´�.
		
		ArrayList<Grade> gradeListAddPercent = gradeDAO.selectGradeListAddPercent(gradeList.size());
		/*
		 * �л����� ��ü �������� ��Ͽ� �ش� �л� ������ ��ü �л� ���������� ������� �߰��� ���� ����� ���´�.
		 * ��, �л� ���� ������ �����(%) ���� ���Ե�  Grade  ����� ��������.
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
				// �˻� ��� ���б������� ����� ���� �۰ų� ���� ������� ���� �������� ������ ScholarshipStudent ��ü�� �����Ͽ�
				// searchScholarshipStudentList�� �߰�
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

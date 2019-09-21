package kr.pe.bluering.sms.service;

import java.sql.Connection;

import kr.pe.bluering.sms.dao.GradeDAO;
import kr.pe.bluering.sms.dao.StudentDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Grade;
import kr.pe.bluering.sms.vo.Student;

public class GradeRegistService {

	public Student getRightStudent(int student_no) {
		
		Connection con = JdbcUtil.getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		
		Student rightStudent = studentDAO.selectStudent(student_no);
		//인자로 던져 준 학생 번호를 가지고 있는 학생정보를 얻어온다.
		JdbcUtil.close(con);
		
		return rightStudent;
	}
	
	public boolean searchGrade(int student_no) {
		/*
		 * 새로 등록할 성적정보가 해당 학생에 대해서 이미 등록이 되어 있는지를 판단하기 위한 메소드를 정의
		 * 이미 해당 학생에 성적정보가 등록되어 있으면 해당 학생에 대한 성적정보를 다시 등록할 수 없다.
		 * */
		boolean isRegisted = false;
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		Grade searchGrade = gradeDAO.selectGrade(student_no);
		// 인자값으로 던져준 학생 번호에 대한 성적정보를 얻어온다.
		
		if(searchGrade != null) {
			isRegisted = true;
		}
		
		JdbcUtil.close(con);
		return isRegisted;
	}

	public boolean registGrade(Grade newGrade) {
		/*
		 * 새로운 성적정보를 등록하는 메소드
		 * 
		 * */
		boolean isRegistedSuccess = false;
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		int insertCount = gradeDAO.insertGrade(newGrade);
		// insert 작업이 성공하면 1, 실패하면 0을 리턴
		
		if(insertCount>0) {
			isRegistedSuccess = true;
		}else {
			isRegistedSuccess = false;
		}
		return isRegistedSuccess;
	}




	
}

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
		//���ڷ� ���� �� �л� ��ȣ�� ������ �ִ� �л������� ���´�.
		JdbcUtil.close(con);
		
		return rightStudent;
	}
	
	public boolean searchGrade(int student_no) {
		/*
		 * ���� ����� ���������� �ش� �л��� ���ؼ� �̹� ����� �Ǿ� �ִ����� �Ǵ��ϱ� ���� �޼ҵ带 ����
		 * �̹� �ش� �л��� ���������� ��ϵǾ� ������ �ش� �л��� ���� ���������� �ٽ� ����� �� ����.
		 * */
		boolean isRegisted = false;
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		Grade searchGrade = gradeDAO.selectGrade(student_no);
		// ���ڰ����� ������ �л� ��ȣ�� ���� ���������� ���´�.
		
		if(searchGrade != null) {
			isRegisted = true;
		}
		
		JdbcUtil.close(con);
		return isRegisted;
	}

	public boolean registGrade(Grade newGrade) {
		/*
		 * ���ο� ���������� ����ϴ� �޼ҵ�
		 * 
		 * */
		boolean isRegistedSuccess = false;
		Connection con = JdbcUtil.getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		int insertCount = gradeDAO.insertGrade(newGrade);
		// insert �۾��� �����ϸ� 1, �����ϸ� 0�� ����
		
		if(insertCount>0) {
			isRegistedSuccess = true;
		}else {
			isRegistedSuccess = false;
		}
		return isRegistedSuccess;
	}




	
}

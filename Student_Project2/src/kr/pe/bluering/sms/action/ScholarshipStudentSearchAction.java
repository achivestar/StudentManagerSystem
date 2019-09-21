package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.service.ScholarshipStudentSearchService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Grade;
import kr.pe.bluering.sms.vo.Scholarship;
import kr.pe.bluering.sms.vo.ScholarshipStudent;

public class ScholarshipStudentSearchAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	ScholarshipStudentSearchService scholarshipStudentSearchService =
			new ScholarshipStudentSearchService();
	@Override
	public void execute(Scanner sc) {
		
		String sc_name = console.getScholar_name("�˻���", sc);
		// �˻��� ���б��� �̸��� ���´�.
		Scholarship searchScholarship = scholarshipStudentSearchService.getSearchScholarship(sc_name);
		// �˻��� ���бݿ� ���� ������ ���´�.
		
		
		if(searchScholarship == null) { //  �˻��� ���бݿ� ���� ������ ���ٸ� �޽��� ����� ����
			console.printScholarshipNotFound(sc_name);
			return;
		}
		
		ArrayList<Grade> scoreListAddPercent = 
				scholarshipStudentSearchService.getScoreListAddPercent();
		/*
		 * �� �л��� ������ �ش� �л� ������ ��ü �л�����  percent(���� ��%�� ���ϴ���) ���� �����Ͽ� ���´�.
		 * */
		
		ArrayList<ScholarshipStudent> scholarshipStudentSearchList = 
				scholarshipStudentSearchService.getSholarshipStudentSearchList(searchScholarship,scoreListAddPercent);
		// �� ���б��� �����ϴ� �л��鿡 ���� ������ ���´�.
		
		
		//���бݿ� ���� �л������� ���� ���ο� ���� �޽��� ���
		if(scholarshipStudentSearchList.size() != 0) {
			//���бݿ� ���� �л������� �������� ���� ���
			console.printScholarshipStudentList(scholarshipStudentSearchList);
		}else {
			console.printScholarshipStudentListNotFound();
		}

	}

}

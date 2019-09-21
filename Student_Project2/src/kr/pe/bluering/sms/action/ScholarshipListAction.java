package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.service.ScholarshipListService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipListAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	ScholarshipListService  scholarship = new ScholarshipListService();
	@Override
	public void execute(Scanner sc) {
		
		ArrayList<Scholarship> scholarshipList = scholarship.getScholarshipList();
		// ��ϵǾ� �ִ� ���б� ������   ArrayList<Scholarship> Ÿ������ ���´�
		
		
		// ��ϵǾ� �ִ� ���б��� ����� �����ϴ����� ���ο� ���� ��� �޽��� ���
		if(scholarshipList!=null) {
			console.printScholarshipList(scholarshipList);
		}else {
			console.printScholarshipListNotFount();
		}

	}

}

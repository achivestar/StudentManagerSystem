package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.controller.StudentController;
import kr.pe.bluering.sms.service.ScholarshipSearchService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipSearchAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	ScholarshipSearchService scholarship = new ScholarshipSearchService();
	@Override
	public void execute(Scanner sc) {
		int searchMenuNum = console.getSearchMenuNumScholarship(sc);
		//�˻� ������ ���´�
		
		ArrayList<Scholarship> searchScholarshipList = null;
		// �˻��� ���б������� �ϳ� �����Ϸ���  ArrayList<Scholarship> Ÿ���� 
		// searchScholarshipList ���� ����
		
		
		if(searchMenuNum==1) { // ���б� �̸����� �˻�
			String sc_name = console.getScholar_name("�˻���", sc);
			searchScholarshipList = scholarship.getSearchScholarshipListBySc_name(sc_name);
		}else if(searchMenuNum==2) { // ���бݱݾ����� �˻�
			int money = console.getMoney("�˻���",sc);
			searchScholarshipList = scholarship.getSearchScholarshipListByMoney(money);
		}else{  //���б� ������ �߸��Ǿ��� ���
			console.printSearchMenuNumWrong();
			Action action = new ScholarshipSearchAction();
			StudentController studentController = new StudentController();
			studentController.requestProcess(action, sc);
			return;
		}
		
		
		// �˻������ ���翩�ο� ���� ����޽��� ���
		if(searchScholarshipList!=null) {
			console.printScholarshipList(searchScholarshipList);
		}else {
			console.printSearchScholarshipNotFount();
		}

	}

}

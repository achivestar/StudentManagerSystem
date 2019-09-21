package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.controller.StudentController;
import kr.pe.bluering.sms.service.GradeSearchService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Grade;

public class GradeSearchAction implements Action {
	
	ConsoleUtil console = new ConsoleUtil();
	GradeSearchService gradeSearchService = new GradeSearchService();
	//�������� �˻� ��û�� ó���ϴ� ����Ͻ� ������ ������  GradeSearchService Ŭ���� ��ü ����

	@Override
	public void execute(Scanner sc) {
		
		int searchMenuNum = console.getSearchGradeMenuNum(sc);
		//�˻������� ����
		
		ArrayList<Grade> searchGradeList = null;
	    
		
		if(searchMenuNum == 1) { //�л��̸����� ������ �˻�
			String student_name = console.getStudent_name("�˻���", sc);
			searchGradeList = gradeSearchService.getSearchGradeListByStudent_name(student_name);
		}else if(searchMenuNum==2) { //�л���ȣ�� ������ �˻�
			int student_no = console.getStudent_no("�˻���", sc);
			searchGradeList = gradeSearchService.getSearchGradeListByStudent_no(student_no);
		}else if(searchMenuNum==3) {  // �л��� �г����� ������ �˻�
			int student_year = console.getGrade("�˻���", sc);
			searchGradeList = gradeSearchService.getSearchGradeListByStudent_year(student_year);
		}else if(searchMenuNum==4) {  // �˻��� ����� ���
			console.printSearchGradeCancel();
			return;
		}else {  //�˻����Ǹ޴���ȣ�� �߸� ������ ���
			console.printSearchMenuNumWrong();
			Action action = new GradeSearchAction();
			StudentController studentController = new StudentController();
			studentController.requestProcess(action, sc);
			return;
		}
		
		
		// �˻��� ���������� �����ϴ����� ���ο� ���� ��� �޽��� ���
		if(searchGradeList != null) {
			console.printGradeList(searchGradeList);
		}else {
			console.printSearchStudentListNotFound();
		}

	}

}

package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.service.GradeListService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Grade;

public class GradeListAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	GradeListService gradeListService = new GradeListService();
	// �������� ��ȸ ��û�� ó���ϴ� ����Ͻ� ������ ���ǵǾ� �ִ�  GradeListService Ŭ���� ��ü ����
	@Override
	public void execute(Scanner sc) {
		
		//��ϵǾ� �ִ� ������������   ArrayList<Grade> Ÿ������ ����
		ArrayList<Grade> gradeList = gradeListService.getGradeList();
		
		// ��ϵ� ���������� �����ϴ����� ���ο� ���� ��� �޽��� ���
		if(gradeList != null) { 
			console.printGradeList(gradeList);
		}else {
			console.printGradeListNotFound();
		}

	}

}

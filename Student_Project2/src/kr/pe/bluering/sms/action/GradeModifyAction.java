package kr.pe.bluering.sms.action;

import java.util.Scanner;

import kr.pe.bluering.sms.service.GradeModifyService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Grade;

public class GradeModifyAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	GradeModifyService gradeModifyService = new GradeModifyService();
	
	@Override
	public void execute(Scanner sc) {
	
		int student_no = console.getStudent_no("������", sc);
		// ������ ������ ����� �Ǵ� �л� ��ȣ�� ����
		
		Grade modifyGrade = gradeModifyService.getModifyGrade(student_no);
		// ������ ����� �Ǵ� �л��� ���� ���������� ����
		
		if(modifyGrade == null) {
			//������ ����̵� �Ǵ� �л� ���������� ���� ���� ���� ��� �޽��� ��� ��, �۾�����
			console.printGradeNotFount(student_no);
			return;
		}
		
		Grade changeGrade = console.getChangeGrade(modifyGrade,sc);
		// �л��� ���� ������ �����ָ鼭 ������ �л��� ���������� ������ �κ�
		boolean isModifySuccess = gradeModifyService.modifyGrade(changeGrade);
		// �л��� ���������� �����ϴ� �κ�
		
		
		// �л��������� ���� ���ο� ���� ��� �޽��� ���
		if(isModifySuccess) {
			console.printModifySuccess(changeGrade);
		}else {
			console.printModifyFail(changeGrade);
		}

	}

}

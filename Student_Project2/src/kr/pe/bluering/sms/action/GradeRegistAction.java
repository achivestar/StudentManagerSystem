package kr.pe.bluering.sms.action;

import java.util.Scanner;

import kr.pe.bluering.sms.service.GradeRegistService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Grade;
import kr.pe.bluering.sms.vo.Student;

public class GradeRegistAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	GradeRegistService gradeRegistService = new GradeRegistService();
	
	@Override
	public void execute(Scanner sc) {
		
		int student_no = console.getStudent_no("�Է���", sc);
		// ������ ���� �Է��� �л��� �л� ��ȣ�� ��� ���� �κ��̴�.
		
		Student rightStudent = gradeRegistService.getRightStudent(student_no);
		// ������ ���� ����� �л��� �����ϴ��� üũ
	
		if(rightStudent==null) {
			console.printStudentNotFound(student_no);
			// ������ ����� �л��� �������� ������ �޽����� ����ϰ�
			return;  // ������� �۾��� ����
		}

		boolean isRegisted = gradeRegistService.searchGrade(student_no);
		// �ش� �л��� ���� ���������� �̹� ��ϵǾ� �ִ��� üũ
		
		if(isRegisted) {
			console.printRegistedGrade(student_no);
			// ���� ���������� ����Ϸ��� �л��� ���� ���������� �̹� �����ϸ� �޽��� ���
			return; //������� �۾� ����
		}
	
		Grade newGrade = console.getNewGrade(student_no,sc);
		// ���� ����� �л��� ���������� ���´�.
		
		
		boolean isRegistSuccess = gradeRegistService.registGrade(newGrade);
		
		// �л����� �Է�(���) �۾��� �������ο� ���� �� ��� �޽��� ���
		if(isRegistSuccess) {
			console.printRegistSuccess(newGrade);
		}else {
			console.printRegistFail(newGrade);
		}

	}


}

package kr.pe.bluering.sms.action;

import java.util.Scanner;

import kr.pe.bluering.sms.service.StudentModifyService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Student;

public class StudentModifyAction implements Action {

	ConsoleUtil consoleutil = new ConsoleUtil();
	StudentModifyService studentmodify = new StudentModifyService();
	//�л����� ���� ��û�� ���� ����Ͻ� ������ ���ǵǾ� �ִ�  StudentModifyService Ŭ���� ��ü��
	// ����
	
	
	@Override
	public void execute(Scanner sc) {
	
		int stu_no = consoleutil.getStudent_no("������",sc);
		// ������ ����� �Ǵ� �л� ��ȣ�� ����
		Student modifyStudent = studentmodify.getModifyStudent(stu_no);
		// ���� ����� �Ǵ� �л��� ���� ������ ���´�.
		
		if(modifyStudent == null) { 
			//���� ����� �Ǵ� �л��� ���� ������ �������� ���� ��� �޽��� ��� ��   execute() �޼ҵ� ���� ����
			consoleutil.printStudentNotFound(stu_no);
			return;
		}
		
		Student changeStudent = consoleutil.getChangeStudent(modifyStudent,sc);
		// ������ �л������� ���´�. ���� ������ �Է� ���� �� ���� ������ ���� �����ָ鼭 ���� ������ �Է� �ޱ� ����
		// getChangeStudent �޼ҵ忡 ���� ������ ��� �ִ� ��ü�� modifyStudent ��ü�� �Ķ���ͷ� ����
		
		boolean isModifySuccess = StudentModifyService.modifyStudent(changeStudent);
		// �л����� ���� �۾��� ó��
		
		if(isModifySuccess) {
			consoleutil.printModifySuccess(stu_no);
		}else {
			consoleutil.printModifyFail(stu_no);
		}
		

	}

}

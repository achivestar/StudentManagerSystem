package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.service.StudentListService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Student;

public class StudentListAction implements Action {

	ConsoleUtil consoleutil = new ConsoleUtil();
	StudentListService studentListService = new StudentListService();
	//  ��ϵǾ� �ִ� ��� �л������� ��� ���� ����Ͻ� ������ �����Ǿ� �ִ�  StudentService Ŭ����
	// ��ü�� ����
	
	@Override
	public void execute(Scanner sc) {
		ArrayList<Student> studentList = studentListService.getStudentList();
		// ���� ��ϵǾ� �ִ� ��� �л�������  ArrayList<Student> Ÿ������ ��ȯ�޴´�
		
		if(studentList != null) {
			consoleutil.printStudentList(studentList);
		}else {
			consoleutil.printStudentListNotFount();
		}

	}

}

package kr.pe.bluering.sms.action;

import java.util.Scanner;

import kr.pe.bluering.sms.service.StudentDeleteService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Student;

public class StudentDeleteAction implements Action {

	ConsoleUtil consoleutil = new ConsoleUtil();
	StudentDeleteService studentDeleteService = new StudentDeleteService();
	
	@Override
	public void execute(Scanner sc) {
		
		int stu_no = consoleutil.getStudent_no("ªË¡¶«“", sc);
		Student deleteStudent = studentDeleteService.getDeleteStudent(stu_no);
		
		if(deleteStudent == null) {
			consoleutil.printStudentNotFound(stu_no);
			return;
		}
		
		boolean isDeleteSuccess = studentDeleteService.deleteStudent(stu_no);
		
		if(isDeleteSuccess) {
			consoleutil.printDeleteSuccess(stu_no);
		}else {
			consoleutil.printDeleteFail(stu_no);
		}
	}

}

package kr.pe.bluering.sms.action;

import java.util.Scanner;

import kr.pe.bluering.sms.service.StudentRegistService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Student;

public class StudentRegistAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	StudentRegistService studentRegistService =  new StudentRegistService();
	
	@Override
	public void execute(Scanner sc) {
		int stu_no = consoleUtil.getStudent_no("",sc);
		
		boolean isStuno = studentRegistService.getStuNo(stu_no);
		// 입력받은  학번이 8자리가 맞는지 검사
		if(!isStuno) {
			consoleUtil.printRegistedStuNo(stu_no);
			return;
		}
		
		boolean isRegisted = studentRegistService.searchStudent(stu_no);
		
		if(isRegisted) {
			consoleUtil.printRegistedStudent(stu_no);
			return;
		}
		
		Student newStudent = consoleUtil.getNewStudent(stu_no, sc);
		
		String unfitForm = studentRegistService.compareBirthRegistForm(newStudent);
		  
		if(unfitForm !=null) { 
			consoleUtil.printUnfitForm(unfitForm);
			return; 
		}
		 
		
		boolean isRegistedStudent = studentRegistService.registStudent(newStudent);
		
		if(isRegistedStudent) {
			consoleUtil.printRegistSuccess(newStudent);
		}else {
			consoleUtil.printRegistFail(newStudent);
		}

	}

}

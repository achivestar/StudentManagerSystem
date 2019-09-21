package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.controller.StudentController;
import kr.pe.bluering.sms.service.StudentSearchService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Student;

public class StudentSearchAction implements Action {

	ConsoleUtil consoleutil = new ConsoleUtil();
	StudentSearchService studentSearchService = new StudentSearchService();
	
	@Override
	public void execute(Scanner sc) {
	
		int searchMenuNum = consoleutil.getSearchMenuNum(sc);
		ArrayList<Student> searchStudentList = null;
		
		if(searchMenuNum==1) {
			String stu_name = consoleutil.getStudent_name("검색할",sc);
			searchStudentList = studentSearchService.getSearchStudentListByStudent_name(stu_name);
		}else if(searchMenuNum==2) {
			int stu_no = consoleutil.getStudent_no("검색할",sc);
			searchStudentList = studentSearchService.getSearchStudentListByStudent_no(stu_no);
		}else if(searchMenuNum==3) {
			int student_year = consoleutil.getGrade("검색할",sc);
			searchStudentList = studentSearchService.getSearchStudentListByStudent_year(student_year);
		}else if(searchMenuNum==4) {
			consoleutil.printSearchStudentCancel();
			return;
		}else {
			consoleutil.printSearchMenuNumWrong();
			Action action = new StudentSearchAction();
			StudentController studentController = new StudentController();
			studentController.requestProcess(action, sc);
			return;
		}
		
		if(searchStudentList != null) {
			consoleutil.printStudentList(searchStudentList);
		}else {
			consoleutil.printSearchStudentListNotFound();
		}

	}

}

package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.service.StudentListService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Student;

public class StudentListAction implements Action {

	ConsoleUtil consoleutil = new ConsoleUtil();
	StudentListService studentListService = new StudentListService();
	//  등록되어 있는 모든 학생정보를 얻어 오는 비즈니스 로직이 구현되어 있는  StudentService 클래스
	// 객체를 생성
	
	@Override
	public void execute(Scanner sc) {
		ArrayList<Student> studentList = studentListService.getStudentList();
		// 현재 등록되어 있는 모든 학생정보를  ArrayList<Student> 타입으로 반환받는다
		
		if(studentList != null) {
			consoleutil.printStudentList(studentList);
		}else {
			consoleutil.printStudentListNotFount();
		}

	}

}

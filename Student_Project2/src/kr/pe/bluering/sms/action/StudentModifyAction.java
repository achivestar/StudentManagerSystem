package kr.pe.bluering.sms.action;

import java.util.Scanner;

import kr.pe.bluering.sms.service.StudentModifyService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Student;

public class StudentModifyAction implements Action {

	ConsoleUtil consoleutil = new ConsoleUtil();
	StudentModifyService studentmodify = new StudentModifyService();
	//학생정보 변경 요청에 대한 비즈니스 로직이 정의되어 있는  StudentModifyService 클래스 객체를
	// 생성
	
	
	@Override
	public void execute(Scanner sc) {
	
		int stu_no = consoleutil.getStudent_no("수정할",sc);
		// 수정할 대상이 되는 학생 번호를 얻어옴
		Student modifyStudent = studentmodify.getModifyStudent(stu_no);
		// 수정 대상이 되는 학생의 이전 정보를 얻어온다.
		
		if(modifyStudent == null) { 
			//수정 대상이 되는 학생에 대한 정보가 존재하지 않을 경우 메시지 출력 후   execute() 메소드 실행 중지
			consoleutil.printStudentNotFound(stu_no);
			return;
		}
		
		Student changeStudent = consoleutil.getChangeStudent(modifyStudent,sc);
		// 수정할 학생정보를 얻어온다. 수정 정보를 입력 받을 때 이전 정보를 먼저 보여주면서 수정 정보를 입력 받기 위해
		// getChangeStudent 메소드에 이전 정보를 담고 있는 객체인 modifyStudent 객체를 파라미터로 전송
		
		boolean isModifySuccess = StudentModifyService.modifyStudent(changeStudent);
		// 학생정보 변경 작업을 처리
		
		if(isModifySuccess) {
			consoleutil.printModifySuccess(stu_no);
		}else {
			consoleutil.printModifyFail(stu_no);
		}
		

	}

}

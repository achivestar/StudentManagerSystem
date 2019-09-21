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
		
		int student_no = console.getStudent_no("입력할", sc);
		// 성적을 새로 입력할 학생의 학생 번호를 얻어 오는 부분이다.
		
		Student rightStudent = gradeRegistService.getRightStudent(student_no);
		// 성적을 새로 등록할 학생이 존재하는지 체크
	
		if(rightStudent==null) {
			console.printStudentNotFound(student_no);
			// 성적을 등록할 학생이 존재하지 않으면 메시지를 출력하고
			return;  // 성적등록 작업을 중지
		}

		boolean isRegisted = gradeRegistService.searchGrade(student_no);
		// 해당 학생에 대한 성적정보가 이미 등록되어 있는지 체크
		
		if(isRegisted) {
			console.printRegistedGrade(student_no);
			// 새로 성적정보를 등록하려는 학생에 대한 성적정보가 이미 존재하면 메시지 출력
			return; //성적등록 작업 중지
		}
	
		Grade newGrade = console.getNewGrade(student_no,sc);
		// 새로 등록할 학생의 성적정보를 얻어온다.
		
		
		boolean isRegistSuccess = gradeRegistService.registGrade(newGrade);
		
		// 학생정보 입력(등록) 작업의 성공여부에 따라 각 결과 메시지 출력
		if(isRegistSuccess) {
			console.printRegistSuccess(newGrade);
		}else {
			console.printRegistFail(newGrade);
		}

	}


}

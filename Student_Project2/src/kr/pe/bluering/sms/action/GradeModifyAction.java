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
	
		int student_no = console.getStudent_no("수정할", sc);
		// 성적을 수정할 대상이 되는 학생 번호를 얻어옴
		
		Grade modifyGrade = gradeModifyService.getModifyGrade(student_no);
		// 수정할 대상이 되는 학생의 이전 성적정보를 얻어옴
		
		if(modifyGrade == null) {
			//수정할 대상이되 되는 학생 성적정보가 존재 하지 않을 경우 메시지 출력 후, 작업중지
			console.printGradeNotFount(student_no);
			return;
		}
		
		Grade changeGrade = console.getChangeGrade(modifyGrade,sc);
		// 학생의 이전 정보를 보여주면서 수정할 학생의 성적정보를 얻어오는 부분
		boolean isModifySuccess = gradeModifyService.modifyGrade(changeGrade);
		// 학생의 성적정보를 수정하는 부분
		
		
		// 학생정보수정 성공 여부에 따라 결과 메시지 출력
		if(isModifySuccess) {
			console.printModifySuccess(changeGrade);
		}else {
			console.printModifyFail(changeGrade);
		}

	}

}

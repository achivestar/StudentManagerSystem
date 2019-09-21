package kr.pe.bluering.sms.action;

import java.util.Scanner;

import kr.pe.bluering.sms.service.GradeDeleteService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Grade;

public class GradeDeleteAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	GradeDeleteService gradeDeleteService = new GradeDeleteService();
	@Override
	public void execute(Scanner sc) {
		
		int student_no = console.getStudent_no("ªË¡¶«“", sc);
		Grade deleteScore = gradeDeleteService.getDeleteScore(student_no);
		
		if(deleteScore == null) {
			console.printGradeNotFount(student_no);
			return;
		}
		
		boolean isDeleteSuccess = gradeDeleteService.deleteGrade(student_no);
		
		if(isDeleteSuccess) {
			console.printDeleteSuccess(deleteScore);
		}else {
			console.printDeleteFail(deleteScore);
		}
	}

}

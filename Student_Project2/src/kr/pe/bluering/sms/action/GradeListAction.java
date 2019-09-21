package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.service.GradeListService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Grade;

public class GradeListAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	GradeListService gradeListService = new GradeListService();
	// 성적정보 조회 요청을 처리하는 비즈니스 로직이 정의되어 있는  GradeListService 클래스 객체 생성
	@Override
	public void execute(Scanner sc) {
		
		//등록되어 있는 성적정보들을   ArrayList<Grade> 타입으로 얻어옴
		ArrayList<Grade> gradeList = gradeListService.getGradeList();
		
		// 등록된 성정정보가 존재하는지의 여부에 따라 결과 메시지 출력
		if(gradeList != null) { 
			console.printGradeList(gradeList);
		}else {
			console.printGradeListNotFound();
		}

	}

}

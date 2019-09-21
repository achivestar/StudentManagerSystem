package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.controller.StudentController;
import kr.pe.bluering.sms.service.GradeSearchService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Grade;

public class GradeSearchAction implements Action {
	
	ConsoleUtil console = new ConsoleUtil();
	GradeSearchService gradeSearchService = new GradeSearchService();
	//성적정보 검색 요청을 처리하는 비즈니스 로직이 구현된  GradeSearchService 클래스 객체 생성

	@Override
	public void execute(Scanner sc) {
		
		int searchMenuNum = console.getSearchGradeMenuNum(sc);
		//검색조건을 얻어옴
		
		ArrayList<Grade> searchGradeList = null;
	    
		
		if(searchMenuNum == 1) { //학생이름으로 성적을 검색
			String student_name = console.getStudent_name("검색할", sc);
			searchGradeList = gradeSearchService.getSearchGradeListByStudent_name(student_name);
		}else if(searchMenuNum==2) { //학생번호로 성적을 검색
			int student_no = console.getStudent_no("검색할", sc);
			searchGradeList = gradeSearchService.getSearchGradeListByStudent_no(student_no);
		}else if(searchMenuNum==3) {  // 학생의 학년으로 성적을 검색
			int student_year = console.getGrade("검색할", sc);
			searchGradeList = gradeSearchService.getSearchGradeListByStudent_year(student_year);
		}else if(searchMenuNum==4) {  // 검색을 취소할 경우
			console.printSearchGradeCancel();
			return;
		}else {  //검색조건메뉴번호를 잘못 눌렀을 경우
			console.printSearchMenuNumWrong();
			Action action = new GradeSearchAction();
			StudentController studentController = new StudentController();
			studentController.requestProcess(action, sc);
			return;
		}
		
		
		// 검색된 성적정보가 존재하는지의 여부에 따라 결과 메시지 출력
		if(searchGradeList != null) {
			console.printGradeList(searchGradeList);
		}else {
			console.printSearchStudentListNotFound();
		}

	}

}

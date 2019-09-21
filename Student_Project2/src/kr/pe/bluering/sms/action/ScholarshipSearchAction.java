package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.controller.StudentController;
import kr.pe.bluering.sms.service.ScholarshipSearchService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipSearchAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	ScholarshipSearchService scholarship = new ScholarshipSearchService();
	@Override
	public void execute(Scanner sc) {
		int searchMenuNum = console.getSearchMenuNumScholarship(sc);
		//검색 조건을 얻어온다
		
		ArrayList<Scholarship> searchScholarshipList = null;
		// 검색한 장학금정보를 하나 저정하려고  ArrayList<Scholarship> 타입의 
		// searchScholarshipList 변수 선언
		
		
		if(searchMenuNum==1) { // 장학금 이름으로 검색
			String sc_name = console.getScholar_name("검색할", sc);
			searchScholarshipList = scholarship.getSearchScholarshipListBySc_name(sc_name);
		}else if(searchMenuNum==2) { // 장학금금액으로 검색
			int money = console.getMoney("검색할",sc);
			searchScholarshipList = scholarship.getSearchScholarshipListByMoney(money);
		}else{  //장학금 조건이 잘못되었을 경우
			console.printSearchMenuNumWrong();
			Action action = new ScholarshipSearchAction();
			StudentController studentController = new StudentController();
			studentController.requestProcess(action, sc);
			return;
		}
		
		
		// 검색결과의 존재여부에 따라 결과메시지 출력
		if(searchScholarshipList!=null) {
			console.printScholarshipList(searchScholarshipList);
		}else {
			console.printSearchScholarshipNotFount();
		}

	}

}

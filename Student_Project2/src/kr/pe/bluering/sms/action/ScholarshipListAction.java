package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.service.ScholarshipListService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipListAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	ScholarshipListService  scholarship = new ScholarshipListService();
	@Override
	public void execute(Scanner sc) {
		
		ArrayList<Scholarship> scholarshipList = scholarship.getScholarshipList();
		// 등록되어 있는 장학금 정보를   ArrayList<Scholarship> 타입으로 얻어온다
		
		
		// 등록되어 있는 장학금의 목록이 존재하는지의 여부에 따라 결과 메시지 출력
		if(scholarshipList!=null) {
			console.printScholarshipList(scholarshipList);
		}else {
			console.printScholarshipListNotFount();
		}

	}

}

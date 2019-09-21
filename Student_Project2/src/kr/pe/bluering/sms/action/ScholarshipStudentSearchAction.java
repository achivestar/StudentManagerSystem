package kr.pe.bluering.sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.service.ScholarshipStudentSearchService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Grade;
import kr.pe.bluering.sms.vo.Scholarship;
import kr.pe.bluering.sms.vo.ScholarshipStudent;

public class ScholarshipStudentSearchAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	ScholarshipStudentSearchService scholarshipStudentSearchService =
			new ScholarshipStudentSearchService();
	@Override
	public void execute(Scanner sc) {
		
		String sc_name = console.getScholar_name("검색할", sc);
		// 검색할 장학금의 이름을 얻어온다.
		Scholarship searchScholarship = scholarshipStudentSearchService.getSearchScholarship(sc_name);
		// 검색할 장학금에 대한 정보를 얻어온다.
		
		
		if(searchScholarship == null) { //  검색할 장학금에 대한 정보가 없다면 메시지 출력후 중지
			console.printScholarshipNotFound(sc_name);
			return;
		}
		
		ArrayList<Grade> scoreListAddPercent = 
				scholarshipStudentSearchService.getScoreListAddPercent();
		/*
		 * 각 학생의 성적을 해당 학생 성적의 전체 학생들의  percent(상위 몇%에 속하는지) 값을 포함하여 얻어온다.
		 * */
		
		ArrayList<ScholarshipStudent> scholarshipStudentSearchList = 
				scholarshipStudentSearchService.getSholarshipStudentSearchList(searchScholarship,scoreListAddPercent);
		// 각 장학금을 수령하는 학생들에 대한 정보를 얻어온다.
		
		
		//장학금에 대한 학생정보가 존재 여부에 따라 메시지 출력
		if(scholarshipStudentSearchList.size() != 0) {
			//장학금에 대한 학생정보가 존재하지 않을 경우
			console.printScholarshipStudentList(scholarshipStudentSearchList);
		}else {
			console.printScholarshipStudentListNotFound();
		}

	}

}

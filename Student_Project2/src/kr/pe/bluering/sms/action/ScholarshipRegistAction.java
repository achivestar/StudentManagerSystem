package kr.pe.bluering.sms.action;

import java.util.Scanner;

import kr.pe.bluering.sms.service.GradeRegistService;
import kr.pe.bluering.sms.service.ScholarshipRegistService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Grade;
import kr.pe.bluering.sms.vo.Scholarship;
import kr.pe.bluering.sms.vo.Student;

public class ScholarshipRegistAction implements Action {

	 ConsoleUtil console = new ConsoleUtil();
	 ScholarshipRegistService scholarshipRegist = new ScholarshipRegistService();
	
	@Override
	public void execute(Scanner sc) {
		
		String sc_name = console.getScholar_name("입력할",sc);
		boolean isRegisted = scholarshipRegist.searchScholarship(sc_name); 
		//새로 등록할 장학금 이름 정보가 이미 존재하는지 여부 판단
		
		
		// 새로 등록할 장학금의 이름 정보가 존재하면 메시지 출력후 작업 중지
		if(isRegisted) { 
			console.printRegistedScholarship(sc_name);
			return;
		}
		
		Scholarship newScholarship = console.getNewScholarShip(sc_name,sc);
		// 세로 등록할 장학금의 정보를 얻어온다
		
		boolean isRegistSuccess = scholarshipRegist.registScholarship(newScholarship);
		// 새로운 장학금 정보를 등록
		
		
		// 새로운 장학금 정보 등록 성공 여부에 따른 결과 메시지 출력
		if(isRegistSuccess) {
			console.printRegistSuccess(newScholarship);
		}else {
			console.printRegistFail(newScholarship);
		}
		
		
		
	}

}

package kr.pe.bluering.sms.action;

import java.util.Scanner;

import kr.pe.bluering.sms.service.ScholarshipModifyService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipModifyAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	ScholarshipModifyService scholarshipmodify = new ScholarshipModifyService();
	
	@Override
	public void execute(Scanner sc) {
		
		String sc_name = console.getScholar_name("수정할", sc);
		// 수정할 대상이 되는 장학금의 종류의 이름을 얻어온다.
		
		Scholarship modifyScholarship = scholarshipmodify.getModifyScholarship(sc_name);
		// 수정할 대상이 되는 장학금의 이전 정보를 얻어온다.
		
		if(modifyScholarship == null) {
			// 수정할 대상이 존재하지 않을 경우 메시지 출력 후 수정작업 중지
			console.printScholarshipListNotFount(sc_name);
			return;
		}
		
		Scholarship changeScholarship = console.getChangeScholarship(modifyScholarship,sc);
		// 장힉금종류의 수정 정보를 얻어온다.
		boolean isModifySuccess = scholarshipmodify.modifyScholarship(changeScholarship);
		// 장학금종류 정보를 수정한다
		
		
		// 장학금종류 정보변경 요청의 성공 여부에 따라 결과 메시지 출력
		if(isModifySuccess) {
			console.printModifySuccess(changeScholarship);
		}else {
			console.printModifyFail(changeScholarship);
		}
	}

}

package kr.pe.bluering.sms.action;

import java.util.Scanner;

import kr.pe.bluering.sms.service.ScholarshipDeleteService;
import kr.pe.bluering.sms.util.ConsoleUtil;
import kr.pe.bluering.sms.vo.Scholarship;

public class ScholarshipDeleteAction implements Action {

	ConsoleUtil console = new ConsoleUtil();
	ScholarshipDeleteService scholarDeleteService = new ScholarshipDeleteService();
	
	@Override
	public void execute(Scanner sc) {
		
		String sc_name = console.getScholar_name("삭제할", sc);
		// 삭제할 장학금종류의 이름을 얻어온다
		
		Scholarship deleteScholarship = scholarDeleteService.getDeleteScholarship(sc_name);
		// 삭제할 대상이 되는 장학금의 종류의 정보를 얻어온다.
		
		
		if(deleteScholarship == null) { // 삭제할 대상의 장학금종류가 존재하지 않는다면
			console.printScholarshipNotFound(sc_name);
			return;
		}
		
		boolean isDeleteSuccess = scholarDeleteService.deleteScore(sc_name);
		//삭제할 대상이 되는 장학금의 정보를 삭제
		
		
		// 장학금삭제 작업 성공 여부에 따라 메시지 출력
		if(isDeleteSuccess) {
			console.printDeleteSucess(deleteScholarship);
		}else {
			console.printDeleteFail(deleteScholarship);
		}

	}

}

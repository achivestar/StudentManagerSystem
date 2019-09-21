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
		
		String sc_name = console.getScholar_name("������", sc);
		// ������ ���б������� �̸��� ���´�
		
		Scholarship deleteScholarship = scholarDeleteService.getDeleteScholarship(sc_name);
		// ������ ����� �Ǵ� ���б��� ������ ������ ���´�.
		
		
		if(deleteScholarship == null) { // ������ ����� ���б������� �������� �ʴ´ٸ�
			console.printScholarshipNotFound(sc_name);
			return;
		}
		
		boolean isDeleteSuccess = scholarDeleteService.deleteScore(sc_name);
		//������ ����� �Ǵ� ���б��� ������ ����
		
		
		// ���бݻ��� �۾� ���� ���ο� ���� �޽��� ���
		if(isDeleteSuccess) {
			console.printDeleteSucess(deleteScholarship);
		}else {
			console.printDeleteFail(deleteScholarship);
		}

	}

}

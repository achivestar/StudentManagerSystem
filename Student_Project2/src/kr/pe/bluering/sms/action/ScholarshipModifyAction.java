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
		
		String sc_name = console.getScholar_name("������", sc);
		// ������ ����� �Ǵ� ���б��� ������ �̸��� ���´�.
		
		Scholarship modifyScholarship = scholarshipmodify.getModifyScholarship(sc_name);
		// ������ ����� �Ǵ� ���б��� ���� ������ ���´�.
		
		if(modifyScholarship == null) {
			// ������ ����� �������� ���� ��� �޽��� ��� �� �����۾� ����
			console.printScholarshipListNotFount(sc_name);
			return;
		}
		
		Scholarship changeScholarship = console.getChangeScholarship(modifyScholarship,sc);
		// ������������ ���� ������ ���´�.
		boolean isModifySuccess = scholarshipmodify.modifyScholarship(changeScholarship);
		// ���б����� ������ �����Ѵ�
		
		
		// ���б����� �������� ��û�� ���� ���ο� ���� ��� �޽��� ���
		if(isModifySuccess) {
			console.printModifySuccess(changeScholarship);
		}else {
			console.printModifyFail(changeScholarship);
		}
	}

}

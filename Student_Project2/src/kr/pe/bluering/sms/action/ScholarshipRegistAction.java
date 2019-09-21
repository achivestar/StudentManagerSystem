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
		
		String sc_name = console.getScholar_name("�Է���",sc);
		boolean isRegisted = scholarshipRegist.searchScholarship(sc_name); 
		//���� ����� ���б� �̸� ������ �̹� �����ϴ��� ���� �Ǵ�
		
		
		// ���� ����� ���б��� �̸� ������ �����ϸ� �޽��� ����� �۾� ����
		if(isRegisted) { 
			console.printRegistedScholarship(sc_name);
			return;
		}
		
		Scholarship newScholarship = console.getNewScholarShip(sc_name,sc);
		// ���� ����� ���б��� ������ ���´�
		
		boolean isRegistSuccess = scholarshipRegist.registScholarship(newScholarship);
		// ���ο� ���б� ������ ���
		
		
		// ���ο� ���б� ���� ��� ���� ���ο� ���� ��� �޽��� ���
		if(isRegistSuccess) {
			console.printRegistSuccess(newScholarship);
		}else {
			console.printRegistFail(newScholarship);
		}
		
		
		
	}

}

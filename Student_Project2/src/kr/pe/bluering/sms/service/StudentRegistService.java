package kr.pe.bluering.sms.service;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import kr.pe.bluering.sms.dao.StudentDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Student;

public class StudentRegistService {

	public String compareBirthRegistForm(Student newStudent) {
	  
	  String unfitForm = null;
	  String birth = newStudent.getStudent_birth();
	  
	  
	 /* 
	  �������(birth)�� ���̰� 10 ���ڰ� �ƴϰų� ù��° "-"������ �ε��� ��, ���� ������ "-" ������ �ε����� 4�� �ƴϰų�,
	  �ι�° "-" ������ �ε��� �� �� �� ������ �;� �ϴ� "-" ������ �ε����� 7�� �ƴϸ� �߸��� ��������� ��ȯ�ϸ鼭 ���ο� �л�������
	  �����Ѵ�*/
	  
	  if(birth.length() != 10 || birth.indexOf("-") != 4 || birth.indexOf("-",5) !=7) 
	  { 
		  return birth; 
	  }
	  
	  
	  // ������Ͽ��� �� �⵵, ��, ��¥ ���� ����.
	  String birthYear = birth.substring(0,4); 
	  String birthMonth = birth.substring(5,7); 
	  String birthDay = birth.substring(8);
	  
	  
	  
	 /* ��������� �������� ���� ��¥�� �⵵������ ũ�ų� �ް��� 12���� ũ�ų� 1���� ������ �߸��� ������ϰ��� ��ȯ�ϸ鼭 �л����� �Է��۾���
	  �����Ѵ�.*/
	  
	  if(Integer.parseInt(birthYear) > Calendar.getInstance().get(Calendar.YEAR) || Integer.parseInt(birthMonth) > 12 || Integer.parseInt(birthMonth)<1) { 
		  return birth; 
	  }
	  
	  int day = 0;
	  
	  switch(birthMonth) { //�� ���� �� ��¥ ���� ���Ѵ� case "01" : case "03" : case "05" :
	  case "07" : case "08" : case "10" : case "12" : day=31; break; 
	  case "04" : case "06" : case "09" : case "11" : day=30; break; 
	  case "02" : day = 28; 
	  //�ش� ������ ������ ���� 2���� �� ��¥ ���� 29��
	  if(Integer.parseInt(birthYear)%4 ==0 && Integer.parseInt(birthYear)%100 !=0 || Integer.parseInt(birthYear)%400 == 0)
	  { 
		  day = 29; 
	  }
	  break;
	  
	  default : 
		  return birth; 
	  }
	  
	  
	  
	  /*��¥ ���� switch~case �������� ������ ������ ũ�ų� 1���� ������ �߸��� ������ϰ��� ��ȯ�ϸ鼭 �л����� ��� �۾��� ����*/
	  
	  if(Integer.parseInt(birthDay) > day || Integer.parseInt(birthDay)<1) { 
		  return birth; 
	  }
	  
	  return unfitForm; 
	 }

	public boolean searchStudent(int stu_no) {
		boolean isRegisted = false;
		Connection con = JdbcUtil.getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		Student student = studentDAO.selectStudent(stu_no);

		if (student != null) {
			isRegisted = true;
		}

		JdbcUtil.close(con);

		return isRegisted;
	}

	public boolean registStudent(Student newStudent) {
		// �л� ���� ��� �۾��� �����ϴ� ��
		boolean isRegistSuccess = false;
		Connection con = JdbcUtil.getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		Date birth = null;

		try {
			// ��������� "2018-08-02" �� ���� ���·� �Է��� �Ǿ������� üũ�ϱ� ���Ͽ�
			// SimpleDateFormat��ü�� ����
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long time = sdf.parse(newStudent.getStudent_birth()).getTime();
			// SimpleDateFormat Ŭ������ parse �޼ҵ带 ����Ͽ� ��¥ ��ü�� ������ �� 1/1000
			// �� ������ ��¥�� ���� �ð����� ����
			birth = new Date(time); // �ð� ���� �̿��Ͽ� Date ��ü�� ��
		} catch (Exception e) {
			e.printStackTrace();
		}

		// �л������� �����ͺ��̽��� �����ϴ� �۾��� ����
		int insertCount = studentDAO.insertStudent(newStudent, birth);

		// insert �۾� �� ����� ����� 1�̻��� ��ȯ�Ǹ� �Է¼���
		if (insertCount > 0) {
			isRegistSuccess = true;
		} else { // �׷��� �ʴٸ� ����
			isRegistSuccess = false;
		}
		return isRegistSuccess;
	}

	public boolean getStuNo(int stu_no) {
		boolean isRegisted = false;
		// �������� ���ڿ��� �����ϰ� �� ���ڿ��� ������ ���ؼ� 8�� ������?
		if(Integer.toString(stu_no).length()==8) {
			isRegisted = true;
		}else {
			isRegisted = false;
		}
		return isRegisted;
	}

}

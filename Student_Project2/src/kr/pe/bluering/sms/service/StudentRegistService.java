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
	  생년월일(birth)의 길이가 10 문자가 아니거나 첫번째 "-"문자의 인덱스 즉, 연도 다음의 "-" 문자의 인덱스가 4가 아니거나,
	  두번째 "-" 문자의 인덱스 즉 달 값 다음에 와야 하는 "-" 문장의 인덱스가 7이 아니면 잘못된 생년월일을 반환하면서 새로운 학생정보를
	  중지한다*/
	  
	  if(birth.length() != 10 || birth.indexOf("-") != 4 || birth.indexOf("-",5) !=7) 
	  { 
		  return birth; 
	  }
	  
	  
	  // 생년월일에서 각 년도, 달, 날짜 값을 얻어옴.
	  String birthYear = birth.substring(0,4); 
	  String birthMonth = birth.substring(5,7); 
	  String birthDay = birth.substring(8);
	  
	  
	  
	 /* 생년월일의 연도값이 오늘 날짜의 년도값보다 크거나 달값이 12보다 크거나 1보다 작으면 잘못된 생년월일값을 반환하면서 학생정보 입력작업을
	  중지한다.*/
	  
	  if(Integer.parseInt(birthYear) > Calendar.getInstance().get(Calendar.YEAR) || Integer.parseInt(birthMonth) > 12 || Integer.parseInt(birthMonth)<1) { 
		  return birth; 
	  }
	  
	  int day = 0;
	  
	  switch(birthMonth) { //각 별로 총 날짜 수를 구한다 case "01" : case "03" : case "05" :
	  case "07" : case "08" : case "10" : case "12" : day=31; break; 
	  case "04" : case "06" : case "09" : case "11" : day=30; break; 
	  case "02" : day = 28; 
	  //해당 연도가 윤년인 경유 2월의 총 날짜 수는 29일
	  if(Integer.parseInt(birthYear)%4 ==0 && Integer.parseInt(birthYear)%100 !=0 || Integer.parseInt(birthYear)%400 == 0)
	  { 
		  day = 29; 
	  }
	  break;
	  
	  default : 
		  return birth; 
	  }
	  
	  
	  
	  /*날짜 값이 switch~case 구문에서 구해진 값보다 크거나 1보다 작으면 잘못된 생년월일값을 반환하면서 학생정보 등록 작업을 중지*/
	  
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
		// 학생 정보 등록 작업을 수행하는 부
		boolean isRegistSuccess = false;
		Connection con = JdbcUtil.getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		Date birth = null;

		try {
			// 생년월일이 "2018-08-02" 와 같은 형태로 입력이 되었는지를 체크하기 위하여
			// SimpleDateFormat객체를 생성
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long time = sdf.parse(newStudent.getStudent_birth()).getTime();
			// SimpleDateFormat 클래스의 parse 메소드를 사용하여 날짜 객체를 생성한 후 1/1000
			// 초 단위로 날짜에 대한 시간값을 얻어옴
			birth = new Date(time); // 시간 값을 이용하여 Date 객체를 생
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 학생정보를 데이터베이스에 삽입하는 작업을 수행
		int insertCount = studentDAO.insertStudent(newStudent, birth);

		// insert 작업 후 적용된 행수가 1이상이 반환되면 입력성공
		if (insertCount > 0) {
			isRegistSuccess = true;
		} else { // 그렇지 않다면 실패
			isRegistSuccess = false;
		}
		return isRegistSuccess;
	}

	public boolean getStuNo(int stu_no) {
		boolean isRegisted = false;
		// 숫자형을 문자열로 변경하고 그 문자열의 개수를 구해서 8과 같은지?
		if(Integer.toString(stu_no).length()==8) {
			isRegisted = true;
		}else {
			isRegisted = false;
		}
		return isRegisted;
	}

}

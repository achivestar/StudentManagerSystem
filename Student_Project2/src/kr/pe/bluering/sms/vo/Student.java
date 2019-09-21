package kr.pe.bluering.sms.vo;

import java.util.Calendar;

import kr.pe.bluering.sms.service.StudentRegistService;

public class Student {

	private int student_no;
	private String student_name;
	private int student_year;
	private String student_addr;
	private String student_tel;
	private String student_birth;
	private int age;
	
	public Student(int student_no, String student_name, int student_year, String student_addr, String student_tel,
			String student_birth) {
		super();
		this.student_no = student_no;
		this.student_name = student_name;
		this.student_year = student_year;
		this.student_addr = student_addr;
		this.student_tel = student_tel;
		this.student_birth = student_birth;
		this.age = calculateAge(student_birth);
		//생일을 문자열(1999-09-09)로 받아서 나이를 구하는 메소드  calculateAge()호출
	}

	
	// 문자열로 전송된 생년월일을 사용하여 학생의 나이를 계산하여 리턴하는 메소드를 정의한 부분
	private int calculateAge(String student_birth) {
		
		StudentRegistService studentRegistService = 
				new StudentRegistService();
		
		  String unfitForm = studentRegistService.compareBirthRegistForm(this);
		  
		  // 생년월일이 올바르게 입력되었는지를 체크하고 올바르지 않으면 나이 계산 작업을 종료 하는 부분
		  if(unfitForm != null)
		  { return 0; }
		 
		int firstHyphenIndex = student_birth.indexOf("-");
		//생년월일(1999-09-09) 문자열에서 첫번째 '-' 문자열이 존재하는 인덱스 번호를 구함
		
		int secondHyphenIndex = student_birth.indexOf("-",firstHyphenIndex+1);
		//생년월일(1999-09-09) 문자열에서 첫번째 '-' 문자열이 존재하는 다음 문자 인덱스 
		//firstHyphenIndex+1  위치부터 검색하여 '-' 문자의 인덱스를 구하는 부분
		//즉 생년월일 문자열에서 두번째 '-' 문자의 위치 인덱스를 구함
		
		int birthYear = Integer.parseInt(student_birth.substring(0,firstHyphenIndex));
		// substring메소드를 사용하여 생년월일 문자의 0번 인덱스 위치부터 firstHyphenIndex 즉, 첫 번째
		//'-' 문자 전까지 추출 그 다음   구해진 연도를 정수 타입으로 변환 parseInt()
		
		int birthMonth = Integer.parseInt(student_birth.substring(firstHyphenIndex+1,secondHyphenIndex));
		// 위와 같은 방법으로  달 값을 구함
		
		int birthDay = Integer.parseInt(student_birth.substring(secondHyphenIndex+1));
		// 위와 같은 방법으로 날짜 값을 구함
		
		
		
		int nowYear = Calendar.getInstance().get(Calendar.YEAR);
		int nowMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		int nowDay = Calendar.getInstance().get(Calendar.DATE);
		// 오늘의 연도, 달, 날짜 값을 구함
		
		int age = nowYear-birthYear; 
		// 오늘 날짜의 연도에서 학생의 생년월일의 년도를 빼서 나이를 계산
		
		return age;  // 계산된 나이를 반환
	}

	public int getStudent_no() {
		return student_no;
	}

	public void setStudent_no(int student_no) {
		this.student_no = student_no;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getStudent_year() {
		return student_year;
	}

	public void setStudent_year(int student_year) {
		this.student_year = student_year;
	}

	public String getStudent_addr() {
		return student_addr;
	}

	public void setStudent_addr(String student_addr) {
		this.student_addr = student_addr;
	}

	public String getStudent_tel() {
		return student_tel;
	}

	public void setStudent_tel(String student_tel) {
		this.student_tel = student_tel;
	}

	public String getStudent_birth() {
		return student_birth;
	}

	public void setStudent_birth(String student_birth) {
		this.student_birth = student_birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}

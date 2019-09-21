package kr.pe.bluering.sms.vo;


// 성적에 관한 정보를 저장하는 클래스
public class Grade {

	private int student_no;
	private String student_name;
	private int grade_kor;
	private int grade_eng;
	private int grade_math;
	private int total;
	private float avg;
	private float percent;
	
	public Grade(int student_no, String student_name, int grade_kor, int grade_eng, 
			int grade_math) {
		super();
		this.student_no = student_no;
		this.student_name = student_name;
		this.grade_kor = grade_kor;
		this.grade_eng = grade_eng;
		this.grade_math = grade_math;
		this.total = calculateTotal(grade_kor,grade_eng,grade_math);
		this.avg = calculateAvg(total);
	}
	
	public Grade(int student_no, String student_name, int grade_kor, 
			int grade_eng, int grade_math, float percent) {
		super();
		this.student_no = student_no;
		this.student_name = student_name;
		this.grade_kor = grade_kor;
		this.grade_eng = grade_eng;
		this.grade_math = grade_math;
		this.percent = calculatePercent(percent);
		this.total = calculateTotal(grade_kor,grade_eng, grade_math);
		this.avg = calculateAvg(total);
	}

	public Grade(int student_no, int grade_kor, int grade_eng, int grade_math) {
		super();
		this.student_no = student_no;
		this.grade_kor = grade_kor;
		this.grade_eng = grade_eng;
		this.grade_math = grade_math;
		this.total = calculateTotal(grade_kor,grade_eng,grade_math);
		this.avg = calculateAvg(total);
	}
	
	

	private float calculateAvg(int total) {
		float avg = (float)total/3;
		avg = (int)(avg * 10 + 0.5f)/10f;
		return avg;
	}

	private float calculatePercent(float percent) {
		percent = (int)(percent * 10 + 0.5f) / 10f;
		return percent;
	}
	

	private int calculateTotal(int grade_kor, int grade_eng, int grade_math) {
		
		return grade_kor+grade_eng+grade_math;
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

	public int getGrade_kor() {
		return grade_kor;
	}

	public void setGrade_kor(int grade_kor) {
		this.grade_kor = grade_kor;
	}

	public int getGrade_eng() {
		return grade_eng;
	}

	public void setGrade_eng(int grade_eng) {
		this.grade_eng = grade_eng;
	}

	public int getGrade_math() {
		return grade_math;
	}

	public void setGrade_math(int grade_math) {
		this.grade_math = grade_math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	

	
	
	
	
	
}

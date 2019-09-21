package kr.pe.bluering.sms.vo;


// Scholarship 테이블에서 하나의 레코드 
// 데이터로 다루어질 장학금의 정보를 저장하는 클래스
public class Scholarship {

	private String scholar_name;
	private int scholar_percent;
	private int scholar_money;
	
	public Scholarship(String scholar_name, int scholar_percent, int scholar_money) {
		super();
		this.scholar_name = scholar_name;
		this.scholar_percent = scholar_percent;
		this.scholar_money = scholar_money;
	}

	public String getScholar_name() {
		return scholar_name;
	}

	public void setScholar_name(String scholar_name) {
		this.scholar_name = scholar_name;
	}

	public int getScholar_percent() {
		return scholar_percent;
	}

	public void setScholar_percent(int scholar_percent) {
		this.scholar_percent = scholar_percent;
	}

	public int getScholar_money() {
		return scholar_money;
	}

	public void setScholar_money(int scholar_money) {
		this.scholar_money = scholar_money;
	}
	
	
	
}

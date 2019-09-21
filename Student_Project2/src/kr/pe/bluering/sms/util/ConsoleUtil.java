package kr.pe.bluering.sms.util;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.vo.Grade;
import kr.pe.bluering.sms.vo.Scholarship;
import kr.pe.bluering.sms.vo.ScholarshipStudent;
import kr.pe.bluering.sms.vo.Student;

public class ConsoleUtil {

	public int getStudent_no(String msgKind, Scanner sc) {
	
		System.out.print("\n> "+msgKind+ " 학번 : ");
		return sc.nextInt();
	}



	public  void printRegistedStudent(int stu_no) {
		System.out.println("> 학번 : " + stu_no + " 학생은 이미 등록되어 있습니다.\n");
		
	}



	public void printUnfitForm(String unfitForm) {
		System.out.println("\n> 생년월일 : "+unfitForm + " 이 형식에 맞지 않습니다. (예시 : 1998-06-14) ");
		
	}



	public Student getNewStudent(int stu_no, Scanner sc) {
		System.out.println("\n> 새로운 학생 정보 입력");
		System.out.print("> 이름 : ");
		String stu_name = sc.next();
		System.out.print("> 학년 : ");
		int grade = sc.nextInt();
		sc.nextLine();
		System.out.print("> 주소  : ");
		String address = sc.nextLine();
		System.out.print("> 전화번호 : ");
		String tel = sc.next();
		System.out.print("> 생년월일 : ");
		String birth =sc.next();
		
		return new Student(stu_no,stu_name,grade,address,tel,birth);
	
	}



	public void printRegistSuccess(Student newStudent) {
		System.out.println("> 학번 : "+newStudent.getStudent_no()+" 학생의 정보가 저장되었습니다.");
		
	}



	public void printRegistFail(Student newStudent) {
		System.out.println("> 학번 : "+newStudent.getStudent_no()+" 학생의 정보 등록이 실패했습니다.");
		
	}



	public void printRegistedStuNo(int stu_no) {
		System.out.println("> 학번 : "+stu_no+" 는 8자리만 허용합니다 ");
		
	}



	public void printStudentList(ArrayList<Student> studentList) {
		System.out.println("> 총 " +studentList.size()+ " 명의 학생을 조회합니다.");
		System.out.println("[학번]     [이름]     [주소]        [전화번호]     [생년월일]     [나이]");
		for(int i=0; i<studentList.size();i++) {
			Student data = studentList.get(i);
			int stu_no = data.getStudent_no();
			String name = data.getStudent_name();
			String addr = data.getStudent_addr();
			String tel = data.getStudent_tel();
			String birth = data.getStudent_birth();
			int age = data.getAge();
			System.out.println(stu_no+" | "+name+" | "+addr+" | "+tel+" | "+birth+" | "+age);
			
		}
	}



	public void printStudentListNotFount() {
		System.out.println("> 등록된 학생정보가 없습니다.");
		
	}



	public void printStudentNotFound(int stu_no) {
		System.out.println("> 학번 : "+stu_no+" 학생의 정보가 존재하지 않습니다.");
		
	}



	public Student getChangeStudent(Student modifyStudent, Scanner sc) {
		System.out.println("\n>변경할 학생정보 입력");
		System.out.println("기존의 이름 : " + modifyStudent.getStudent_name());
		System.out.print("수정할 이름 : ");
		String stu_name = sc.next();
		
		System.out.println("기존의 학년 : " + modifyStudent.getStudent_year());
		System.out.print("수정할  학년 : ");
		int grade = sc.nextInt();
		sc.nextLine();
		System.out.println("기존의 주소: " + modifyStudent.getStudent_addr());
		System.out.print("수정할 주소 : ");
		String address = sc.nextLine();
		
		System.out.println("기존의  전화번호: " + modifyStudent.getStudent_tel());
		System.out.print("수정할 전화번호 : ");
		String tel = sc.next();
		
		return new Student(modifyStudent.getStudent_no(), 
				stu_name, grade, address, tel, modifyStudent.getStudent_birth());

	}



	public void printModifySuccess(int stu_no) {
		System.out.println("> 학번 : "+stu_no+ " 학생의 정보가 수정되었습니다.");
		
	}



	public void printModifyFail(int stu_no) {
		System.out.println("> 학번 : "+stu_no+" 학생의 정보 수정이 실패했습니다.");
		
	}



	public void printDeleteSuccess(int stu_no) {
		System.out.println("> 학번 : "+stu_no+ " 학생의 정보가 삭제되었습니다.");
		
	}



	public void printDeleteFail(int stu_no) {
		System.out.println("> 학번 : "+stu_no+" 학생의 정보 삭제가 실패했습니다.");
		
	}



	public int getSearchMenuNum(Scanner sc) {
		System.out.println("\n            <학생정보검색>           ");
		System.out.println("              1.이름으로 검색                        ");
		System.out.println("              2.학번으로 검색                        ");
		System.out.println("              3.학년으로 검색                        ");
		System.out.println("              4.검색취소                               ");
		System.out.print("                선택 :");
		return sc.nextInt();
	}



	public String getStudent_name(String msgkind, Scanner sc) {
		System.out.print("\n "+msgkind+ " 이름 : ");
		return sc.next();
	}



	public int getGrade(String msgkind, Scanner sc) {
		System.out.print("\n "+msgkind+ " 학년 : ");
		return sc.nextInt();
	}



	public void printSearchStudentCancel() {
		System.out.println("          학생정보 관리 화면으로 이동합니다. ");
		
	}



	public void printSearchMenuNumWrong() {
		System.out.println("            잘못 선택하였습니다.          ");
		
	}



	public void printSearchStudentListNotFound() {
		System.out.println("> 검색조건에 해당하는 학생정보가 존재하지 않습니다.");	
	}


	
    /* 성적정보입력*/
	public Grade getNewGrade(int student_no, Scanner sc) {
		System.out.println("\n> 새로운 성적정보 입력");
		
		System.out.print("> 국어점수:");
		int grade_kor = sc.nextInt();
		
		System.out.print("> 영어점수:");
		int grade_eng = sc.nextInt();
		
		System.out.print("> 수학점수:");
		int grade_math = sc.nextInt();
		
		return new Grade(student_no,grade_kor,grade_eng,grade_math);
	}

	public void printRegistedGrade(int student_no) {
		System.out.println("> 학번 : " + student_no+" 학생의 성적은 이미 등록되어 있습니다.");
		
	}

	public void printRegistSuccess(Grade newGrade) {
		System.out.println(">"+newGrade.getStudent_no()+" 학생의 성적이 입력되었습니다.");
		
	}
	public void printRegistFail(Grade newGrade) {
		System.out.println(">"+newGrade.getStudent_no()+" 학생의 성적입력을 실패했습니다.");
		
	}


	
	/* 성적정보조회 */
	public void printGradeList(ArrayList<Grade> gradeList) {
		System.out.println("\n< 총 "+gradeList.size()+ " 명의 학생성적을 조회합니다");
		System.out.println("[학번]       [이름]  [국어]  [수학]  [영어]  [총점]  [평균]");
		for(int i=0; i<gradeList.size();i++) {
			Grade data = gradeList.get(i);
			System.out.println(data.getStudent_no()+"    "+data.getStudent_name()+"       "+data.getGrade_kor()+"    "
					+data.getGrade_math()+"    "+data.getGrade_eng()+"    "+data.getTotal()+"    "+data.getAvg());
		}
		
	}

	public void printGradeListNotFound() {
		System.out.println("> 등록된 성적정보가 존재하지 않습니다.\n");
		
	}


    /* 성적정보검색 */
	public int getSearchGradeMenuNum(Scanner sc) {
		System.out.println("\n〓〓〓〓〓〓〓〓〓〓 < 성적정보 검색 >〓〓〓〓〓〓〓〓〓");
		System.out.println("              1.이름으로 검색               ");
		System.out.println("              2.학번으로 검색               ");
		System.out.println("              3.학년으로 검색               ");
		System.out.println("              4.검색취소                      ");
        System.out.print("            선택:");
		return sc.nextInt();
	}

	public void printSearchGradeCancel() {
		System.out.println("\n 성적정보 괸리 화면으로 이동합니다.");
		
	}



	/* 성적정보수정*/
	public void printGradeNotFount(int stu_no) {
		System.out.println("> 학번 : "+ stu_no + " 학생의 성적정보가 존재하지 않습니다.");
	}



	public Grade getChangeGrade(Grade modifyGrade, Scanner sc) {
		System.out.println("\n> 변경할 성적정보 입력");
		System.out.println("> 기존 국어성적 : " +modifyGrade.getGrade_kor());
		System.out.print("> 수정할 국어성적 : ");
		int kor_grade = sc.nextInt();
		System.out.println("> 기존 영어성적 : " +modifyGrade.getGrade_eng());
		System.out.print("> 수정할 영어성적 : ");
		int eng_grade = sc.nextInt();
		System.out.println("> 기존  수학성적 : " +modifyGrade.getGrade_math());
		System.out.print("> 수정할 수학성적 : ");
		int math_grade = sc.nextInt();
		
		return new Grade(modifyGrade.getStudent_no(),modifyGrade.getStudent_name(),kor_grade, eng_grade, math_grade);
	}



	public void printModifySuccess(Grade changeGrade) {
		System.out.println("> 학번 : "+changeGrade.getStudent_no()+" 학생의 성적정보가 수정되었습니다.");
	}



	public void printModifyFail(Grade changeGrade) {
		System.out.println("> 학번 : "+changeGrade.getStudent_no()+" 학생의 성적정보 수정이 실패했습니다.");
		
	}


	// 성적정보 삭제
	public void printDeleteSuccess(Grade deleteScore) {
		System.out.println("> 학번 : " + deleteScore.getStudent_no()+" 학생의 성적정보가 삭제되었습니다.\n");
		
	}



	public void printDeleteFail(Grade deleteScore) {
		System.out.println("> 학번 : " + deleteScore.getStudent_no()+" 학생의 성적정보 삭제가 실패했습니다.\n");
		
	}


	// 장학금 관련 콘솔

	public String getScholar_name(String msgkind, Scanner sc) {
		System.out.print("\n> "+msgkind+" 장학금명 : ");
		return sc.next();
	}



	public void printRegistedScholarship(String sc_name) {
		System.out.println("> 장학금명 : " +sc_name+ " 은 이미 등록되어 있습니다.\n");
		
	}



	public Scholarship getNewScholarShip(String sc_name, Scanner sc) {
		System.out.println("\n> 새로운 장학금 입력  ");
		System.out.print("> 백분율 : ");
		int percent = sc.nextInt();
		
		System.out.print("> 장학금액 : ");
		int money = sc.nextInt();
				
		return new Scholarship(sc_name, percent, money);
	}



	public void printRegistSuccess(Scholarship newScholarship) {
		System.out.println("> 장학금명 : "+newScholarship.getScholar_name()+" 의 정보가 등록되었습니다.");
	}



	public void printRegistFail(Scholarship newScholarship) {
		System.out.println("> 장학금명 : "+newScholarship.getScholar_name()+" 의 정보등록이 실패했습니다.");
		
	}



	public void printScholarshipList(ArrayList<Scholarship> scholarshipList) {
		System.out.println("\n< 총 "+ scholarshipList.size()+" 종류의 장학금을 조회합니다.>");
		System.out.println("[장학금명]     [상위백분율]     [금액]");
		for(int i=0; i<scholarshipList.size();i++) {
			Scholarship data = scholarshipList.get(i);
			System.out.println(data.getScholar_name()+"     "+data.getScholar_percent()+"     "+data.getScholar_money());
		}
		
	}



	public void printScholarshipListNotFount() {
		System.out.println("\n> 등록된 장학금 정보가 존재하지 않습니다.");
	}



	public int getSearchMenuNumScholarship(Scanner sc) {
		System.out.println("\n--------<장학금종류>--------");
		System.out.println("          1.장학금명으로 검색        ");
		System.out.println("          2.장학금액으로 검색        ");
		System.out.print("           선택 :  ");
		return sc.nextInt();
	}



	public int getMoney(String msgKind, Scanner sc) {
		System.out.print("\n> "+msgKind+ " 금액 : ");
		return sc.nextInt();
	}



	public void printSearchScholarshipNotFount() {
		System.out.println("> 검색조건에 해당하다는 장학금 정보가 존재하지 않습니다.");
		
	}



	public void printScholarshipListNotFount(String sc_name) {
		System.out.println("> 장학금명 : "+sc_name+ " 정보가 존재하지 않습니다.");
		
	}



	public Scholarship getChangeScholarship(Scholarship modifyScholarship, Scanner sc) {
		System.out.println("\n> 변경할 장학금 정보 입력 : ");
		System.out.println("> 기존 백분율 : " + modifyScholarship.getScholar_percent());
		System.out.print("> 수정 백분율 :");
		int scholar_percent = sc.nextInt();
		System.out.println("> 기존 장학금액 : " + modifyScholarship.getScholar_money());
		System.out.print("> 수정 장학금액 : ");
		int scholar_money = sc.nextInt();
		return new Scholarship(modifyScholarship.getScholar_name(), scholar_percent, scholar_money);
	}



	public void printModifySuccess(Scholarship changeScholarship) {
		System.out.println("> 장학금명 : "+changeScholarship.getScholar_name()+" 의 정보가 수정되었습니다.");
		
	}

	public void printModifyFail(Scholarship changeScholarship) {
		System.out.println("> 장학금명 : "+changeScholarship.getScholar_name()+" 의 정보수정 이 실패했습니다.");
		
	}



	public void printScholarshipNotFound(String sc_name) {
		System.out.println("> 장학금명 : "+sc_name+ " 정보가 존재하지 않습니다.");
		
	}



	public void printDeleteSucess(Scholarship deleteScholarship) {
		System.out.println("\n> 장학금명 : "+deleteScholarship.getScholar_name()+" 의 정보 삭제가 성공했습니다.");
		
	}



	public void printDeleteFail(Scholarship deleteScholarship) {
		System.out.println("\n> 장학금명 : "+deleteScholarship.getScholar_name()+" 의 정보 삭제가 실패했습니다.");
		
	}



	public void printScholarshipStudentList(ArrayList<ScholarshipStudent> scholarshipStudentSearchList) {
		
		System.out.println("\n <총 "+scholarshipStudentSearchList.size()+" 명의 수혜학생을 조회합니다.");
		System.out.println("[학번]   [이름]   [평균]   [백분율]   [장학금명]   [장학금액]");
		for(int i=0; i<scholarshipStudentSearchList.size();i++) {
			ScholarshipStudent data = scholarshipStudentSearchList.get(i);
			System.out.println(data.getStudent_no()+"  "+data.getStudent_name()+"  "+data.getAvg()+" "+data.getPercent()+" "+data.getScholar_name()+" "+
			data.getScholar_money());
		}
		
	}

	public void printScholarshipStudentListNotFound() {
		System.out.println("> 등록된 장학금 수혜학생정보가 존재하지 않습니다.");
	}









}

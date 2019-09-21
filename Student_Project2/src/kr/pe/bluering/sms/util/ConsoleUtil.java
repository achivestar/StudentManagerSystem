package kr.pe.bluering.sms.util;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.sms.vo.Grade;
import kr.pe.bluering.sms.vo.Scholarship;
import kr.pe.bluering.sms.vo.ScholarshipStudent;
import kr.pe.bluering.sms.vo.Student;

public class ConsoleUtil {

	public int getStudent_no(String msgKind, Scanner sc) {
	
		System.out.print("\n> "+msgKind+ " �й� : ");
		return sc.nextInt();
	}



	public  void printRegistedStudent(int stu_no) {
		System.out.println("> �й� : " + stu_no + " �л��� �̹� ��ϵǾ� �ֽ��ϴ�.\n");
		
	}



	public void printUnfitForm(String unfitForm) {
		System.out.println("\n> ������� : "+unfitForm + " �� ���Ŀ� ���� �ʽ��ϴ�. (���� : 1998-06-14) ");
		
	}



	public Student getNewStudent(int stu_no, Scanner sc) {
		System.out.println("\n> ���ο� �л� ���� �Է�");
		System.out.print("> �̸� : ");
		String stu_name = sc.next();
		System.out.print("> �г� : ");
		int grade = sc.nextInt();
		sc.nextLine();
		System.out.print("> �ּ�  : ");
		String address = sc.nextLine();
		System.out.print("> ��ȭ��ȣ : ");
		String tel = sc.next();
		System.out.print("> ������� : ");
		String birth =sc.next();
		
		return new Student(stu_no,stu_name,grade,address,tel,birth);
	
	}



	public void printRegistSuccess(Student newStudent) {
		System.out.println("> �й� : "+newStudent.getStudent_no()+" �л��� ������ ����Ǿ����ϴ�.");
		
	}



	public void printRegistFail(Student newStudent) {
		System.out.println("> �й� : "+newStudent.getStudent_no()+" �л��� ���� ����� �����߽��ϴ�.");
		
	}



	public void printRegistedStuNo(int stu_no) {
		System.out.println("> �й� : "+stu_no+" �� 8�ڸ��� ����մϴ� ");
		
	}



	public void printStudentList(ArrayList<Student> studentList) {
		System.out.println("> �� " +studentList.size()+ " ���� �л��� ��ȸ�մϴ�.");
		System.out.println("[�й�]     [�̸�]     [�ּ�]        [��ȭ��ȣ]     [�������]     [����]");
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
		System.out.println("> ��ϵ� �л������� �����ϴ�.");
		
	}



	public void printStudentNotFound(int stu_no) {
		System.out.println("> �й� : "+stu_no+" �л��� ������ �������� �ʽ��ϴ�.");
		
	}



	public Student getChangeStudent(Student modifyStudent, Scanner sc) {
		System.out.println("\n>������ �л����� �Է�");
		System.out.println("������ �̸� : " + modifyStudent.getStudent_name());
		System.out.print("������ �̸� : ");
		String stu_name = sc.next();
		
		System.out.println("������ �г� : " + modifyStudent.getStudent_year());
		System.out.print("������  �г� : ");
		int grade = sc.nextInt();
		sc.nextLine();
		System.out.println("������ �ּ�: " + modifyStudent.getStudent_addr());
		System.out.print("������ �ּ� : ");
		String address = sc.nextLine();
		
		System.out.println("������  ��ȭ��ȣ: " + modifyStudent.getStudent_tel());
		System.out.print("������ ��ȭ��ȣ : ");
		String tel = sc.next();
		
		return new Student(modifyStudent.getStudent_no(), 
				stu_name, grade, address, tel, modifyStudent.getStudent_birth());

	}



	public void printModifySuccess(int stu_no) {
		System.out.println("> �й� : "+stu_no+ " �л��� ������ �����Ǿ����ϴ�.");
		
	}



	public void printModifyFail(int stu_no) {
		System.out.println("> �й� : "+stu_no+" �л��� ���� ������ �����߽��ϴ�.");
		
	}



	public void printDeleteSuccess(int stu_no) {
		System.out.println("> �й� : "+stu_no+ " �л��� ������ �����Ǿ����ϴ�.");
		
	}



	public void printDeleteFail(int stu_no) {
		System.out.println("> �й� : "+stu_no+" �л��� ���� ������ �����߽��ϴ�.");
		
	}



	public int getSearchMenuNum(Scanner sc) {
		System.out.println("\n            <�л������˻�>           ");
		System.out.println("              1.�̸����� �˻�                        ");
		System.out.println("              2.�й����� �˻�                        ");
		System.out.println("              3.�г����� �˻�                        ");
		System.out.println("              4.�˻����                               ");
		System.out.print("                ���� :");
		return sc.nextInt();
	}



	public String getStudent_name(String msgkind, Scanner sc) {
		System.out.print("\n "+msgkind+ " �̸� : ");
		return sc.next();
	}



	public int getGrade(String msgkind, Scanner sc) {
		System.out.print("\n "+msgkind+ " �г� : ");
		return sc.nextInt();
	}



	public void printSearchStudentCancel() {
		System.out.println("          �л����� ���� ȭ������ �̵��մϴ�. ");
		
	}



	public void printSearchMenuNumWrong() {
		System.out.println("            �߸� �����Ͽ����ϴ�.          ");
		
	}



	public void printSearchStudentListNotFound() {
		System.out.println("> �˻����ǿ� �ش��ϴ� �л������� �������� �ʽ��ϴ�.");	
	}


	
    /* ���������Է�*/
	public Grade getNewGrade(int student_no, Scanner sc) {
		System.out.println("\n> ���ο� �������� �Է�");
		
		System.out.print("> ��������:");
		int grade_kor = sc.nextInt();
		
		System.out.print("> ��������:");
		int grade_eng = sc.nextInt();
		
		System.out.print("> ��������:");
		int grade_math = sc.nextInt();
		
		return new Grade(student_no,grade_kor,grade_eng,grade_math);
	}

	public void printRegistedGrade(int student_no) {
		System.out.println("> �й� : " + student_no+" �л��� ������ �̹� ��ϵǾ� �ֽ��ϴ�.");
		
	}

	public void printRegistSuccess(Grade newGrade) {
		System.out.println(">"+newGrade.getStudent_no()+" �л��� ������ �ԷµǾ����ϴ�.");
		
	}
	public void printRegistFail(Grade newGrade) {
		System.out.println(">"+newGrade.getStudent_no()+" �л��� �����Է��� �����߽��ϴ�.");
		
	}


	
	/* ����������ȸ */
	public void printGradeList(ArrayList<Grade> gradeList) {
		System.out.println("\n< �� "+gradeList.size()+ " ���� �л������� ��ȸ�մϴ�");
		System.out.println("[�й�]       [�̸�]  [����]  [����]  [����]  [����]  [���]");
		for(int i=0; i<gradeList.size();i++) {
			Grade data = gradeList.get(i);
			System.out.println(data.getStudent_no()+"    "+data.getStudent_name()+"       "+data.getGrade_kor()+"    "
					+data.getGrade_math()+"    "+data.getGrade_eng()+"    "+data.getTotal()+"    "+data.getAvg());
		}
		
	}

	public void printGradeListNotFound() {
		System.out.println("> ��ϵ� ���������� �������� �ʽ��ϴ�.\n");
		
	}


    /* ���������˻� */
	public int getSearchGradeMenuNum(Scanner sc) {
		System.out.println("\n����������� < �������� �˻� >����������");
		System.out.println("              1.�̸����� �˻�               ");
		System.out.println("              2.�й����� �˻�               ");
		System.out.println("              3.�г����� �˻�               ");
		System.out.println("              4.�˻����                      ");
        System.out.print("            ����:");
		return sc.nextInt();
	}

	public void printSearchGradeCancel() {
		System.out.println("\n �������� ���� ȭ������ �̵��մϴ�.");
		
	}



	/* ������������*/
	public void printGradeNotFount(int stu_no) {
		System.out.println("> �й� : "+ stu_no + " �л��� ���������� �������� �ʽ��ϴ�.");
	}



	public Grade getChangeGrade(Grade modifyGrade, Scanner sc) {
		System.out.println("\n> ������ �������� �Է�");
		System.out.println("> ���� ����� : " +modifyGrade.getGrade_kor());
		System.out.print("> ������ ����� : ");
		int kor_grade = sc.nextInt();
		System.out.println("> ���� ����� : " +modifyGrade.getGrade_eng());
		System.out.print("> ������ ����� : ");
		int eng_grade = sc.nextInt();
		System.out.println("> ����  ���м��� : " +modifyGrade.getGrade_math());
		System.out.print("> ������ ���м��� : ");
		int math_grade = sc.nextInt();
		
		return new Grade(modifyGrade.getStudent_no(),modifyGrade.getStudent_name(),kor_grade, eng_grade, math_grade);
	}



	public void printModifySuccess(Grade changeGrade) {
		System.out.println("> �й� : "+changeGrade.getStudent_no()+" �л��� ���������� �����Ǿ����ϴ�.");
	}



	public void printModifyFail(Grade changeGrade) {
		System.out.println("> �й� : "+changeGrade.getStudent_no()+" �л��� �������� ������ �����߽��ϴ�.");
		
	}


	// �������� ����
	public void printDeleteSuccess(Grade deleteScore) {
		System.out.println("> �й� : " + deleteScore.getStudent_no()+" �л��� ���������� �����Ǿ����ϴ�.\n");
		
	}



	public void printDeleteFail(Grade deleteScore) {
		System.out.println("> �й� : " + deleteScore.getStudent_no()+" �л��� �������� ������ �����߽��ϴ�.\n");
		
	}


	// ���б� ���� �ܼ�

	public String getScholar_name(String msgkind, Scanner sc) {
		System.out.print("\n> "+msgkind+" ���бݸ� : ");
		return sc.next();
	}



	public void printRegistedScholarship(String sc_name) {
		System.out.println("> ���бݸ� : " +sc_name+ " �� �̹� ��ϵǾ� �ֽ��ϴ�.\n");
		
	}



	public Scholarship getNewScholarShip(String sc_name, Scanner sc) {
		System.out.println("\n> ���ο� ���б� �Է�  ");
		System.out.print("> ����� : ");
		int percent = sc.nextInt();
		
		System.out.print("> ���бݾ� : ");
		int money = sc.nextInt();
				
		return new Scholarship(sc_name, percent, money);
	}



	public void printRegistSuccess(Scholarship newScholarship) {
		System.out.println("> ���бݸ� : "+newScholarship.getScholar_name()+" �� ������ ��ϵǾ����ϴ�.");
	}



	public void printRegistFail(Scholarship newScholarship) {
		System.out.println("> ���бݸ� : "+newScholarship.getScholar_name()+" �� ��������� �����߽��ϴ�.");
		
	}



	public void printScholarshipList(ArrayList<Scholarship> scholarshipList) {
		System.out.println("\n< �� "+ scholarshipList.size()+" ������ ���б��� ��ȸ�մϴ�.>");
		System.out.println("[���бݸ�]     [���������]     [�ݾ�]");
		for(int i=0; i<scholarshipList.size();i++) {
			Scholarship data = scholarshipList.get(i);
			System.out.println(data.getScholar_name()+"     "+data.getScholar_percent()+"     "+data.getScholar_money());
		}
		
	}



	public void printScholarshipListNotFount() {
		System.out.println("\n> ��ϵ� ���б� ������ �������� �ʽ��ϴ�.");
	}



	public int getSearchMenuNumScholarship(Scanner sc) {
		System.out.println("\n--------<���б�����>--------");
		System.out.println("          1.���бݸ����� �˻�        ");
		System.out.println("          2.���бݾ����� �˻�        ");
		System.out.print("           ���� :  ");
		return sc.nextInt();
	}



	public int getMoney(String msgKind, Scanner sc) {
		System.out.print("\n> "+msgKind+ " �ݾ� : ");
		return sc.nextInt();
	}



	public void printSearchScholarshipNotFount() {
		System.out.println("> �˻����ǿ� �ش��ϴٴ� ���б� ������ �������� �ʽ��ϴ�.");
		
	}



	public void printScholarshipListNotFount(String sc_name) {
		System.out.println("> ���бݸ� : "+sc_name+ " ������ �������� �ʽ��ϴ�.");
		
	}



	public Scholarship getChangeScholarship(Scholarship modifyScholarship, Scanner sc) {
		System.out.println("\n> ������ ���б� ���� �Է� : ");
		System.out.println("> ���� ����� : " + modifyScholarship.getScholar_percent());
		System.out.print("> ���� ����� :");
		int scholar_percent = sc.nextInt();
		System.out.println("> ���� ���бݾ� : " + modifyScholarship.getScholar_money());
		System.out.print("> ���� ���бݾ� : ");
		int scholar_money = sc.nextInt();
		return new Scholarship(modifyScholarship.getScholar_name(), scholar_percent, scholar_money);
	}



	public void printModifySuccess(Scholarship changeScholarship) {
		System.out.println("> ���бݸ� : "+changeScholarship.getScholar_name()+" �� ������ �����Ǿ����ϴ�.");
		
	}

	public void printModifyFail(Scholarship changeScholarship) {
		System.out.println("> ���бݸ� : "+changeScholarship.getScholar_name()+" �� �������� �� �����߽��ϴ�.");
		
	}



	public void printScholarshipNotFound(String sc_name) {
		System.out.println("> ���бݸ� : "+sc_name+ " ������ �������� �ʽ��ϴ�.");
		
	}



	public void printDeleteSucess(Scholarship deleteScholarship) {
		System.out.println("\n> ���бݸ� : "+deleteScholarship.getScholar_name()+" �� ���� ������ �����߽��ϴ�.");
		
	}



	public void printDeleteFail(Scholarship deleteScholarship) {
		System.out.println("\n> ���бݸ� : "+deleteScholarship.getScholar_name()+" �� ���� ������ �����߽��ϴ�.");
		
	}



	public void printScholarshipStudentList(ArrayList<ScholarshipStudent> scholarshipStudentSearchList) {
		
		System.out.println("\n <�� "+scholarshipStudentSearchList.size()+" ���� �����л��� ��ȸ�մϴ�.");
		System.out.println("[�й�]   [�̸�]   [���]   [�����]   [���бݸ�]   [���бݾ�]");
		for(int i=0; i<scholarshipStudentSearchList.size();i++) {
			ScholarshipStudent data = scholarshipStudentSearchList.get(i);
			System.out.println(data.getStudent_no()+"  "+data.getStudent_name()+"  "+data.getAvg()+" "+data.getPercent()+" "+data.getScholar_name()+" "+
			data.getScholar_money());
		}
		
	}

	public void printScholarshipStudentListNotFound() {
		System.out.println("> ��ϵ� ���б� �����л������� �������� �ʽ��ϴ�.");
	}









}

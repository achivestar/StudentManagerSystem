package kr.pe.bluering.sms.ui;

import java.util.Scanner;

import kr.pe.bluering.sms.action.Action;
import kr.pe.bluering.sms.action.GradeDeleteAction;
import kr.pe.bluering.sms.action.GradeListAction;
import kr.pe.bluering.sms.action.GradeModifyAction;
import kr.pe.bluering.sms.action.GradeRegistAction;
import kr.pe.bluering.sms.action.GradeSearchAction;
import kr.pe.bluering.sms.action.ScholarshipDeleteAction;
import kr.pe.bluering.sms.action.ScholarshipListAction;
import kr.pe.bluering.sms.action.ScholarshipModifyAction;
import kr.pe.bluering.sms.action.ScholarshipRegistAction;
import kr.pe.bluering.sms.action.ScholarshipSearchAction;
import kr.pe.bluering.sms.action.ScholarshipStudentSearchAction;
import kr.pe.bluering.sms.action.StudentDeleteAction;
import kr.pe.bluering.sms.action.StudentListAction;
import kr.pe.bluering.sms.action.StudentModifyAction;
import kr.pe.bluering.sms.action.StudentRegistAction;
import kr.pe.bluering.sms.action.StudentSearchAction;
import kr.pe.bluering.sms.controller.StudentController;

public class StudentUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean isOuterStop = false;
		//외부 메뉴 실행을 계속 할 것인지 종료할것인지 판단할 변수
		boolean isInnerStop = false;
		//내부 메뉴 실행을 계속 할 것인지  종료할것인지 판단할 변수
		int outerMenu = 0;
		// 외부 메뉴를 저장하는 변수 선언
		int innerMenu = 0;
		// 내부 메뉴를 저장하는 변수 선언
		
		Action action = null;
		StudentController studentController = new StudentController();
		
		do {  
			// 외부 메뉴를 사용자에게 출력해 주는 부분. 
			System.out.println("\n-------------< 학생정보관리 프로그램 >-------------");
			System.out.println("                 1.학생정보관리                                         ");
			System.out.println("                 2.성적정보관리                                         ");
			System.out.println("                 3.장학금관리                                            ");
			System.out.println("                 4.프로그램종료                                         ");
			System.out.print("                   선택 : ");
			outerMenu = sc.nextInt();  //외부 메뉴를 사용자로부터 입력 받는 부분
			isInnerStop = false; 
			/*
			 * 외부메뉴가 선택되었을 때 각 외부 메뉴에 대한 내부 메뉴를 빠져나올지를 결정하는 변수 isInnerStop 변수값을 false로 초기화
			 * 해준다. 즉 각 외부 메뉴에 대한 내부 메뉴를 처리하고 다른 외부 메뉴 선택시 기존에 선택된 내부 메뉴가 영향을 주지 않게 하기 위함.
			 */
			
			switch(outerMenu) {
			case 1 : 
				do {
					System.out.println("\n---------------< 학생정보관리 >-----------------");
					System.out.println("                   1.학생정보입력                                     ");
					System.out.println("                   2.학생정보조회                                     ");
					System.out.println("                   3.학생정보검색                                     ");
					System.out.println("                   4.학생정보변경                                     ");
					System.out.println("                   5.학생정보삭제                                     ");
					System.out.println("                   6.첫 화면으로                                       ");
					System.out.print("                  선택 : ");
					innerMenu = sc.nextInt();
					switch(innerMenu) {
					case 1 : action = new StudentRegistAction();
					         break;
					case 2 : action = new StudentListAction();
							 break;
					case 3 : action = new StudentSearchAction();
							 break;
					case 4 : action = new StudentModifyAction();
							 break;
					case 5 : action = new StudentDeleteAction();
							 break;
					case 6 : System.out.println("첫 화면으로 이동합니다.");
					         isInnerStop = true;
					         action = null;
					         break;
					default : System.out.println("    잘못 입력 하셨습니다.\n");
					          action = null;
					          break;
		
					}
					  if(action != null)
						   studentController.requestProcess(action,sc);
				}while(!isInnerStop);
				break;
			case 2 :
				do {
					System.out.println("\n--------------------< 성적정보관리 >--------------------");
					System.out.println("                   1.성적정보입력                                         ");
					System.out.println("                   2.성적정보조회                                         ");
					System.out.println("                   3.성적정보검색                                         ");
					System.out.println("                   4.성적정보변경                                         ");
					System.out.println("                   5.성적정보삭제                                         ");
					System.out.println("                   6.첫 화면으로                                           ");
					System.out.print("          선택 : ");
					innerMenu = sc.nextInt();
					switch(innerMenu) {
					case 1 : action = new GradeRegistAction();
					         break;
					case 2 : action = new GradeListAction();
							 break;
					case 3 : action = new GradeSearchAction();
						     break;
					case 4 : action = new GradeModifyAction();
					         break;
					case 5 : action = new GradeDeleteAction();
					         break;
					case 6 : System.out.println("             첫 화면으로 이동합니다.\n");
							 isInnerStop = true;
							 action = null;
							 break;
					default :System.out.println("              잘못 입력하셨습니다.\n");
					         isInnerStop = true;
					         action = null;
					         break;
					         
					
					} 
					 if(action != null) {
					      studentController.requestProcess(action,sc);
					 }
				}while(!isInnerStop);
				break;
				
			case 3: 
				do {
					System.out.println("\n--------------------< 장학금 관리 >-------------------");
					System.out.println("                      1.장학금종류추가                                         ");
					System.out.println("                      2.장학금종류조회                                        ");
					System.out.println("                      3.장학금종류검색                                         ");
					System.out.println("                      4.장학금종류변경                                         ");
					System.out.println("                      5.장학금종류삭제                                         ");
					System.out.println("                      6.장학금별 수혜학생 검색                               ");
					System.out.println("                      7.첫 화면으로                                              ");
					System.out.print("               선택 : ");
					innerMenu = sc.nextInt();
					switch(innerMenu) {
					case 1:  action = new ScholarshipRegistAction();
					         break;
					case 2 : action = new ScholarshipListAction();
					         break;
					case 3 : action = new ScholarshipSearchAction();
					         break;
					case 4 : action = new ScholarshipModifyAction();
					         break;
					case 5 : action = new ScholarshipDeleteAction();
					         break;
					case 6 : action = new ScholarshipStudentSearchAction();
					         break;
					case 7 : System.out.println("\n           첫 화면으로 이동합니다.");
					         isInnerStop = true;
					         action =  null;
					         break;
					default : System.out.println("           잘못 입력하셨습니다.\n");
					          action = null;
					          break;
					}
			        
					 if(action != null) {
						 studentController.requestProcess(action,sc);
					 }
				}while(!isInnerStop);
				break;
				
			case 4 : System.out.println("        프로그램을 종료합니다..  Bye");
					 isOuterStop = true;
					 break;
		    default : System.out.println("           잘못 입력하셨습니다.       ");
		              break;
		    
			}
		}while(!isOuterStop);

	}

}

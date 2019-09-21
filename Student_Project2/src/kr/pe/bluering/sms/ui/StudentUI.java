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
		//�ܺ� �޴� ������ ��� �� ������ �����Ұ����� �Ǵ��� ����
		boolean isInnerStop = false;
		//���� �޴� ������ ��� �� ������  �����Ұ����� �Ǵ��� ����
		int outerMenu = 0;
		// �ܺ� �޴��� �����ϴ� ���� ����
		int innerMenu = 0;
		// ���� �޴��� �����ϴ� ���� ����
		
		Action action = null;
		StudentController studentController = new StudentController();
		
		do {  
			// �ܺ� �޴��� ����ڿ��� ����� �ִ� �κ�. 
			System.out.println("\n-------------< �л��������� ���α׷� >-------------");
			System.out.println("                 1.�л���������                                         ");
			System.out.println("                 2.������������                                         ");
			System.out.println("                 3.���бݰ���                                            ");
			System.out.println("                 4.���α׷�����                                         ");
			System.out.print("                   ���� : ");
			outerMenu = sc.nextInt();  //�ܺ� �޴��� ����ڷκ��� �Է� �޴� �κ�
			isInnerStop = false; 
			/*
			 * �ܺθ޴��� ���õǾ��� �� �� �ܺ� �޴��� ���� ���� �޴��� ������������ �����ϴ� ���� isInnerStop �������� false�� �ʱ�ȭ
			 * ���ش�. �� �� �ܺ� �޴��� ���� ���� �޴��� ó���ϰ� �ٸ� �ܺ� �޴� ���ý� ������ ���õ� ���� �޴��� ������ ���� �ʰ� �ϱ� ����.
			 */
			
			switch(outerMenu) {
			case 1 : 
				do {
					System.out.println("\n---------------< �л��������� >-----------------");
					System.out.println("                   1.�л������Է�                                     ");
					System.out.println("                   2.�л�������ȸ                                     ");
					System.out.println("                   3.�л������˻�                                     ");
					System.out.println("                   4.�л���������                                     ");
					System.out.println("                   5.�л���������                                     ");
					System.out.println("                   6.ù ȭ������                                       ");
					System.out.print("                  ���� : ");
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
					case 6 : System.out.println("ù ȭ������ �̵��մϴ�.");
					         isInnerStop = true;
					         action = null;
					         break;
					default : System.out.println("    �߸� �Է� �ϼ̽��ϴ�.\n");
					          action = null;
					          break;
		
					}
					  if(action != null)
						   studentController.requestProcess(action,sc);
				}while(!isInnerStop);
				break;
			case 2 :
				do {
					System.out.println("\n--------------------< ������������ >--------------------");
					System.out.println("                   1.���������Է�                                         ");
					System.out.println("                   2.����������ȸ                                         ");
					System.out.println("                   3.���������˻�                                         ");
					System.out.println("                   4.������������                                         ");
					System.out.println("                   5.������������                                         ");
					System.out.println("                   6.ù ȭ������                                           ");
					System.out.print("          ���� : ");
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
					case 6 : System.out.println("             ù ȭ������ �̵��մϴ�.\n");
							 isInnerStop = true;
							 action = null;
							 break;
					default :System.out.println("              �߸� �Է��ϼ̽��ϴ�.\n");
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
					System.out.println("\n--------------------< ���б� ���� >-------------------");
					System.out.println("                      1.���б������߰�                                         ");
					System.out.println("                      2.���б�������ȸ                                        ");
					System.out.println("                      3.���б������˻�                                         ");
					System.out.println("                      4.���б���������                                         ");
					System.out.println("                      5.���б���������                                         ");
					System.out.println("                      6.���бݺ� �����л� �˻�                               ");
					System.out.println("                      7.ù ȭ������                                              ");
					System.out.print("               ���� : ");
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
					case 7 : System.out.println("\n           ù ȭ������ �̵��մϴ�.");
					         isInnerStop = true;
					         action =  null;
					         break;
					default : System.out.println("           �߸� �Է��ϼ̽��ϴ�.\n");
					          action = null;
					          break;
					}
			        
					 if(action != null) {
						 studentController.requestProcess(action,sc);
					 }
				}while(!isInnerStop);
				break;
				
			case 4 : System.out.println("        ���α׷��� �����մϴ�..  Bye");
					 isOuterStop = true;
					 break;
		    default : System.out.println("           �߸� �Է��ϼ̽��ϴ�.       ");
		              break;
		    
			}
		}while(!isOuterStop);

	}

}

package kr.pe.bluering.sms.controller;

import java.util.Scanner;

import kr.pe.bluering.sms.action.Action;

public class StudentController {

	public void requestProcess(Action action, Scanner sc) {
		try {
			action.execute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

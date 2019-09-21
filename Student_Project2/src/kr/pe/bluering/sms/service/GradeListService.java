package kr.pe.bluering.sms.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.pe.bluering.sms.dao.GradeDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Grade;

public class GradeListService {

	public ArrayList<Grade> getGradeList() {
		// ��ϵǾ� �ִ� ���������� ��ȯ�ϴ� �޼ҵ� ����
		
		Connection con = JdbcUtil.getConnection();
		GradeDAO scoreDAO = new GradeDAO(con);
		ArrayList<Grade> scoreList = scoreDAO.selectGradeList();
		//db���� ��ü ���������� ��ȸ�Ͽ� ArrayList<Grade> Ÿ������ ��ȯ
		JdbcUtil.close(con);
		return scoreList;
	}

}

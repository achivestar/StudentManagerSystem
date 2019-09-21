package kr.pe.bluering.sms.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.pe.bluering.sms.dao.GradeDAO;
import kr.pe.bluering.sms.db.JdbcUtil;
import kr.pe.bluering.sms.vo.Grade;

public class GradeListService {

	public ArrayList<Grade> getGradeList() {
		// 등록되어 있는 성적정보를 반환하는 메소드 정의
		
		Connection con = JdbcUtil.getConnection();
		GradeDAO scoreDAO = new GradeDAO(con);
		ArrayList<Grade> scoreList = scoreDAO.selectGradeList();
		//db에서 전체 성적정보를 조회하여 ArrayList<Grade> 타입으로 반환
		JdbcUtil.close(con);
		return scoreList;
	}

}

package com.google.app.departements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDAO {
	
	@Autowired
	private SqlSession session;
	
	//전체 목록 list
	public List<DepartmentDTO> list() throws Exception {
		System.out.println("DAO List");
		
		return session.selectList("com.google.app.departements.DepartmentDAO.list");//namespace.id명
		
		//1. DB 연결 > ip정보, port 정보, id /pw 정보, 어떤 DB를 사용할 건지를 알아야 연결할 수 있음
		
		
		//2. sql문 생성
		
		
		//3. 미리 전송
		
		
		//4. ? 물음표값 세팅
		
		//5. 최종 전송 및 결과 처리 > 최종 값은 resultset에 담긴다. 
		
		
		//6. 연결 해제 
	}
}

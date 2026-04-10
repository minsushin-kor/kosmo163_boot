package com.google.app.professor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProfessorMapperTest {

	@Autowired
	private ProfessorMapper professorMapper;
	
	@Test
	void getCount() throws Exception {
		Long result = professorMapper.getCount();
		System.out.println(result);
		assertNotEquals(0, result);
	}
	
	@Test
	void testList() {
//		fail("Not yet implemented");
	}

	@Test
	void testDetail() {
//		fail("Not yet implemented");
	}

	@Test
	void testCreate() throws Exception {
		// dummy data
//		ProfessorDTO professorDTO = new ProfessorDTO();
//		professorDTO.setProfessorNo("P150");
//		professorDTO.setProfessorName("홍길동");
//		professorDTO.setProfessorSsn("00-00");
//		professorDTO.setProfessorAddress("서울시");
//		professorDTO.setDepartmentNo("058");
//		
//		int result = professorMapper.create(professorDTO);
//		assertNotEquals(0, result);
	}

	@Test
	void testUpdate() throws Exception {
//		ProfessorDTO professorDTO = new ProfessorDTO();
//		professorDTO.setProfessorNo("P150");
//		professorDTO.setProfessorName("카리나");
//		professorDTO.setProfessorSsn("11-11");
//		professorDTO.setProfessorAddress("서울특별시");
//		professorDTO.setDepartmentNo("060");
//				
//		int result = professorMapper.update(professorDTO);
//		assertNotEquals(0, result);
	}

	@Test
	void testDelete() throws Exception {
//		ProfessorDTO professorDTO = new ProfessorDTO();
//		
//		professorDTO.setProfessorNo("P150");
//		int result = professorMapper.delete(professorDTO);
//		assertNotEquals(0, result);
	}

}

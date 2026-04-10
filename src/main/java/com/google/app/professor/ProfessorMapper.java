package com.google.app.professor;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.google.app.pages.Pager;

@Mapper
@Repository
public interface ProfessorMapper {
	
	// getcount
	public Long getCount() throws Exception;
	
	//list
	public List<ProfessorDTO> list(Pager pager) throws Exception; 
	
	//detail
	public ProfessorDTO detail(ProfessorDTO professorDTO) throws Exception;
	
	//create
	public int create(ProfessorDTO professorDTO) throws Exception;
	
	//update
	public int update(ProfessorDTO professorDTO) throws Exception;
	
	//delete
	public int delete(ProfessorDTO professorDTO) throws Exception;
}

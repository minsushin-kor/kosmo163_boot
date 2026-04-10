package com.google.app.professor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.app.pages.Pager;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorMapper professorMapper;
	
	public List<ProfessorDTO> list(Pager pager) throws Exception {
				
		pager.makePageNumber(professorMapper.getCount());		
		return professorMapper.list(pager);
	}
	
	public ProfessorDTO detail(ProfessorDTO professorDTO) throws Exception {
		return professorMapper.detail(professorDTO);
	}
	
	public int update(ProfessorDTO professorDTO) throws Exception{
		return professorMapper.update(professorDTO);
	}
	
	public int create(ProfessorDTO professorDTO) throws Exception{
		return professorMapper.create(professorDTO);
	}
	
	public int delete(ProfessorDTO professorDTO) throws Exception{
		return professorMapper.delete(professorDTO);
	}
}

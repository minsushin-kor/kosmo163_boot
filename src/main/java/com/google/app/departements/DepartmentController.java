package com.google.app.departements;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	//전체 목록 불러오기 메서드 - list
	
	@GetMapping("list")
	public void list() throws Exception {
		System.out.println("Controller List");
		List<DepartmentDTO> ar = departmentService.list();
		
//		// for(초기식;조건식;증감식){}
//		for(int i=0;i>ar.size();i++) {
//			System.out.println(ar.get(i));
//		}
		// 향상된 for 문
		// for(꺼낸 데이터타입 변수명:collection << collection에 있는 크기만큼 돌린다.){}
		for(DepartmentDTO dto:ar) {
			System.out.println(dto);
		}
	}
	
}

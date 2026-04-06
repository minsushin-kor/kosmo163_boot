package com.google.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;


//annotation : 설명과 기능을 포함
@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public void join(MemberDTO memberDTO) {
		//파라미터의 이름과 dto의 setter의 이름이 같아야 한다. 
		System.out.println(memberDTO.getAge());
		
	}
	
	
//	@RequestMapping(value = "join", method = RequestMethod.POST)
//	public void join(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		String date = request.getParameter("birth");
//		String [] nums = request.getParameterValues("num");
//		
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(date);
//		System.out.println(nums.length);
//	}	
//	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원 가입 페이지");
				
		return "member/join";
	}
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
}

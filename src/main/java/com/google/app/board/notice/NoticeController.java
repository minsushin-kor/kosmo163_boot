package com.google.app.board.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.app.pages.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception {
		List<NoticeDTO>	ar = noticeService.list(pager);
		model.addAttribute("list", ar);
		
		return "board/list";
	}
}

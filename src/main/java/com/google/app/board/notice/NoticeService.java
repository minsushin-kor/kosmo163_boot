package com.google.app.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.app.pages.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	public List<NoticeDTO> list(Pager pager) throws Exception {
			
		pager.makePageNumber(noticeMapper.getCount());
								
		return noticeMapper.list(pager);
	}
	
	// notice 페이지 목록 만들기 위해 make 메서드 선언
	// 중복사용되고 있어서 pager 클래스에 선언 후 삭제
	
	public int create(NoticeDTO noticeDTO) throws Exception {
		return noticeMapper.create(noticeDTO);
	}
	
}

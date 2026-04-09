package com.google.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeTest {

	@Autowired
	private NoticeMapper noticeMapper;

	@Test
	void testList() throws Exception {

		List<NoticeDTO> ar = noticeMapper.list();
		assertNotEquals(0, ar.size());
	}

	@Test
	void testCreate() throws Exception {
		int idx=1;
		for (int i = 0; i < 110; i++) {
			NoticeDTO noticeDTO = new NoticeDTO();

			noticeDTO.setBoardTitle("제목입니다."+i);
			noticeDTO.setBoardContents("내용입니다."+i);
			noticeDTO.setBoardWriter("P00"+idx);

			int result = noticeMapper.create(noticeDTO);
			idx++;
			
			if(idx>9) {
				idx=1;
			}
			
			if(i%10==0) {
				
				Thread.sleep(1000);
			}
		}
		System.out.println("finish");
	}
}

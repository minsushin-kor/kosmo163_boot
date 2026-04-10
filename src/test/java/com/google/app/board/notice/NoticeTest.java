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
	void getCount() throws Exception{
		Long result = noticeMapper.getCount();
		System.out.println(result);
		assertNotEquals(0, result);
	}
}

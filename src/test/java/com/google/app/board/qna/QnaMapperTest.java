package com.google.app.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class QnaMapperTest {

	@Autowired
	private QnaMapper qnaMapper;
	
	@Test
	void testCreate() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		
		qnaDTO.setBoardTitle("답글2");
		qnaDTO.setBoardContents("답글내용2");
		qnaDTO.setBoardWriter("user");
		qnaDTO.setBoardRef(280L);
		qnaDTO.setBoardStep(2L);
		qnaDTO.setBoardDepth(2L);
		
		int result = qnaMapper.create(qnaDTO);
		assertEquals(1, result);
	}
}

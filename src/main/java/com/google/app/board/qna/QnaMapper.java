package com.google.app.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.app.board.notice.NoticeDTO;
import com.google.app.pages.Pager;

@Mapper
public interface QnaMapper {
	
	public List<QnaDTO> list(Pager pager) throws Exception;
	
	public QnaDTO detail(QnaDTO QnaDTO)throws Exception;
	
	public Long getCount(Pager pager)throws Exception;
	
	public int create(QnaDTO qnaDTO) throws Exception;
	
	public int createFile(QnaFileDTO qnaFileDTO) throws Exception;
	
	public int replyUpdate(QnaDTO qnaDTO) throws Exception;
}

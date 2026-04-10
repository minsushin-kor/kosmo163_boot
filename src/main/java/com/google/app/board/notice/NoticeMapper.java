package com.google.app.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.google.app.pages.Pager;

@Mapper
public interface NoticeMapper {
	// count
	public Long getCount() throws Exception;
	
	// list
	public List<NoticeDTO> list(Pager pager) throws Exception;
	
	// detail
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception;
	
	// create
	public int create(NoticeDTO noticeDTO) throws Exception;
		
	// update
	public int update(NoticeDTO noticeDTO) throws Exception;
	
	// delete
	public int delete(NoticeDTO noticeDTO) throws Exception;
	
}

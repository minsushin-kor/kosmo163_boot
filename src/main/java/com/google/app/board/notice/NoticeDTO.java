package com.google.app.board.notice;

import java.time.LocalDateTime;
import java.util.List;

import com.google.app.board.BoardDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeDTO extends BoardDTO{
	
	private List<NoticeFileDTO> list;
}

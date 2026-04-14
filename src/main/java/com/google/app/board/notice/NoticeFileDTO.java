package com.google.app.board.notice;

import com.google.app.files.FileDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NoticeFileDTO extends FileDTO{
	
	private Long boardNum;
}

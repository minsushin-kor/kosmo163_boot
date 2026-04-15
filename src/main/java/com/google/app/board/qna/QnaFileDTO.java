package com.google.app.board.qna;

import com.google.app.files.FileDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnaFileDTO extends FileDTO{
	
	private Long boardNum;
}

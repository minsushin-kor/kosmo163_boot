package com.google.app.board.notice;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeDTO {
	private Long boardNum;
	private String boardTitle;
	private String boardContents;
	private String boardWriter;
	private LocalDateTime boardDate;
	private Long boardHit;
}

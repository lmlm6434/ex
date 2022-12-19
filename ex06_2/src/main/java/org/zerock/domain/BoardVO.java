package org.zerock.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private int replyCnt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date regdate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date updatedate;
	
	private List<BoardAttachVO> attachList;
	
}









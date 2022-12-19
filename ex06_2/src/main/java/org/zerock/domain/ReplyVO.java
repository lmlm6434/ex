package org.zerock.domain;

import java.util.Date;

import lombok.Data;


@Data
public class ReplyVO {
	private Long rno; // PK
	private Long bno; // FK
	private String reply;
	private String replyer;
	private Date replydate;
	private Date updatedate;
}



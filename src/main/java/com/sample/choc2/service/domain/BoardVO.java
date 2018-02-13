package com.sample.choc2.service.domain;

import java.util.Date;

public class BoardVO {
	
	private int board_no;
	private String title;
	private String writer;
	private String content;
	private int viewcnt;
	private Date regdate;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "[ board_no : "+ board_no
				+"/ title : " + title
				+"/ writer : " + writer
				+"/ viewcnt : " + viewcnt
				+"/ regdate : " + regdate + " ]"	;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
}

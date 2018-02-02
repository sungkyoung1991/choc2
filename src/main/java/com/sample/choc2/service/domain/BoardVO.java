package com.sample.choc2.service.domain;

import java.util.Date;

public class BoardVO {
	
	private int bno;
	private String title;
	private String writer;
	private String content;
	private int viewcnt;
	private Date regdate;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
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
		return "[ bno : "+ bno
				+"/ title : " + title
				+"/ writer : " + writer
				+"/ viewcnt : " + viewcnt
				+"/ regdate : " + regdate + " ]"	;
	}
}

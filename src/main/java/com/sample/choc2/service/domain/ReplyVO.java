package com.sample.choc2.service.domain;

import java.util.Date;

public class ReplyVO {
	private int boardNo;
	private int replyNo;
	private String replytext;
	private String replyer;
	private Date regdate;
	private Date updatedate;

	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "[ boardNo : "+ boardNo
				+"/ replyNo : " + replyNo
				+"/ replytext : " + replytext
				+"/ replyer : " + replyer
				+"/ regdate : " + regdate
				+"/ updatedate : " + updatedate + " ]"	;
	}

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
}

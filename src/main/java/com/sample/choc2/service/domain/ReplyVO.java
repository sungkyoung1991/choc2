package com.sample.choc2.service.domain;

import java.util.Date;

public class ReplyVO {
	private int board_no;
	private int reply_no;
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
		return "[ board_no : "+ board_no
				+"/ reply_no : " + reply_no
				+"/ replytext : " + replytext
				+"/ replyer : " + replyer
				+"/ regdate : " + regdate
				+"/ updatedate : " + updatedate + " ]"	;
	}

	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
}

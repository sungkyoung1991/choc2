package com.sample.choc2.service.domain;

public class Board {

	/// Field
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardRegDate;
	private UserVO writer;
	private boolean blind;
	private String thumbnailUrl;

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardRegDate() {
		
		return this.boardRegDate.split("\\.")[0];
		
//		return boardRegDate;
	}

	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
	}

	public UserVO getWriter() {
		return writer;
	}

	public void setWriter(UserVO writer) {
		this.writer = writer;
	}

	public boolean isBlind() {
		return blind;
	}

	public void setBlind(boolean blind) {
		this.blind = blind;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardRegDate=" + boardRegDate + ", writer=" + writer + ", blind=" + blind + ", thumbnailUrl="
				+ thumbnailUrl + "]";
	}

}

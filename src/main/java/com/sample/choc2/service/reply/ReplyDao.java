package com.sample.choc2.service.reply;

import java.util.List;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.service.domain.ReplyVO;

public interface ReplyDao {

	// =========================ReplyDao=========================
	public void createReply(ReplyVO replyVO) throws Exception;

	public void updateReply(ReplyVO replyVO) throws Exception;

	public void deleteReply(Integer reply_no) throws Exception;

	public List<ReplyVO> listPageReply(Integer board_no, Criteria cri) throws Exception;

	// 페이징처리
	public int countReply(Integer board_no) throws Exception;

	// 게시물의 댓글 수
	public int getBoardNo(Integer board_no) throws Exception;

	public void updateReplyCnt(Integer board_no, int amount) throws Exception;
}

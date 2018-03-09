package com.sample.choc2.service.reply;

import java.util.List;
import java.util.Map;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.ReplyVO;

public interface ReplyDao {

	// =========================ReplyDao=========================
	public void createReply(ReplyVO replyVO) throws Exception;

	public void updateReply(ReplyVO replyVO) throws Exception;

	public void deleteReply(Integer replyNo) throws Exception;

	public List<ReplyVO> listPageReply(Integer boardNo,Search search) throws Exception;

	// 페이징처리
	public int countReply(Integer boardNo) throws Exception;

	// 게시물의 댓글 수
	public int getBoardNo(Integer boardNo) throws Exception;

	public void updateReplyCnt(Integer boardNo, int amount) throws Exception;

} 

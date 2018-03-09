package com.sample.choc2.service.reply;

import java.util.List;
import java.util.Map;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.ReplyVO;

public interface ReplyService {
	// =========================ReplyService=========================
	
	public void createReply(ReplyVO replyVO)throws Exception;
	
	public void updateReply(ReplyVO replyVO)throws Exception;
	
	public void deleteReply(Integer replyNo) throws Exception;
	
	public Map<String,Object> listReplyPage(Integer bno, Search search)throws Exception;
	
//	public int countReply(Integer boardNo)throws Exception;
	
	public int getBoardNo(Integer boardNo) throws Exception;

	public void updateReplyCnt(Integer boardNo, int amount) throws Exception;
	
}

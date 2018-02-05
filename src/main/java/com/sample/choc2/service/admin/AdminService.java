package com.sample.choc2.service.admin;

import java.util.List;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.BoardVO;
import com.sample.choc2.service.domain.ReplyVO;

public interface AdminService {
	
//=========================BoardDao=========================	
	public void create(BoardVO vo)throws Exception;
	
	public BoardVO get(Integer bno)throws Exception;
	
	public void update(BoardVO vo)throws Exception;
	
	public void delete(Integer bno)throws Exception;
	
	public List<BoardVO> list(SearchCriteria cri)throws Exception;
	
	public int totalCount(SearchCriteria cri)throws Exception;
//=========================ReplyDao=========================
	public void createReply(ReplyVO vo)throws Exception;
	
	public void updateReply(ReplyVO vo)throws Exception;
	
	public void deleteReply(Integer rno) throws Exception;
	
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri)throws Exception;
	
	public int countReply(Integer bno)throws Exception;
	
	
}

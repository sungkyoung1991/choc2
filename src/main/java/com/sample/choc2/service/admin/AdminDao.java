package com.sample.choc2.service.admin;

import java.util.List;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.BoardVO;
import com.sample.choc2.service.domain.ReplyVO;

public interface AdminDao {
//=========================BoardDao=========================
	public void create(BoardVO vo)throws Exception;
	
	public BoardVO get(Integer bno)throws Exception;
	
	public void update(BoardVO vo)throws Exception;
	
	public void delete(Integer bno)throws Exception;
	
	public List<BoardVO> list(SearchCriteria cri)throws Exception;
	
	public int totalCount(SearchCriteria cri)throws Exception;
//=========================ReplyDao=========================	
	public void createReply(ReplyVO vo) throws Exception;
	
	public void updateReply(ReplyVO vo) throws Exception;
	
	public void deleteReply(Integer rno) throws Exception;
	
	public List<ReplyVO> listPageReply(Integer bno,Criteria cri)throws Exception;
	//페이징처리
	public int countReply(Integer bno) throws Exception;
	//게시물의 댓글 수 
	public int getBno(Integer bno) throws Exception;


}

package com.sample.choc2.service.admin;

import java.util.List;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.BoardVO;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.ReplyVO;

public interface AdminDao {
	
	// =========================BoardDao=========================
	
	public void createBoard(BoardVO boardVO) throws Exception;

	public BoardVO getBoard(Integer boardNo) throws Exception;

	public void updateBoard(BoardVO boardVO) throws Exception;

	public void deleteBoard(Integer boardNo) throws Exception;

	public List<BoardVO> listBoard(SearchCriteria cri) throws Exception;

	public int countBoard(SearchCriteria cri) throws Exception;

	public void updateViewCnt(Integer boardNo) throws Exception;
	
	
}

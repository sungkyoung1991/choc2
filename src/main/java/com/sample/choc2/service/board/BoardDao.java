package com.sample.choc2.service.board;

import java.util.List;
import java.util.Map;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.BoardVO;

public interface BoardDao {
	
	// =========================BoardDao=========================
	
	public void createBoard(BoardVO boardVO) throws Exception;

	public BoardVO getBoard(Integer boardNo) throws Exception;

	public void updateBoard(BoardVO boardVO) throws Exception;

	public void deleteBoard(Integer boardNo) throws Exception;

	public List<BoardVO> getBoardList(Search search) throws Exception;

	public int totalCountBoard(Search search) throws Exception;

	public void updateViewCnt(Integer boardNo) throws Exception;
	
	
}

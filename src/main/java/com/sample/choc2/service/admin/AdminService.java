package com.sample.choc2.service.admin;

import java.util.List;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.BoardVO;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.ReplyVO;

public interface AdminService {
	
	// =========================BoardService=========================	
	
	public void createBoard(BoardVO boardVO)throws Exception;
	
	public BoardVO getBoard(Integer board_no)throws Exception;
	
	public void updateBoard(BoardVO boardVO)throws Exception;
	
	public void deleteBoard(Integer board_no)throws Exception;
	
	public List<BoardVO> listBoard(SearchCriteria cri)throws Exception;
	
	public int countBoard(SearchCriteria cri)throws Exception;
	
	public void updateViewCnt(Integer board_no) throws Exception;


	// =========================CosmeticService=========================
	/*
	public void createCosmetic(CosmeticVO cosmeticVO)throws Exception;
	
	public CosmeticVO getCosmetic(Integer cosmetic_no)throws Exception;
	
	public void updateCosmetic(CosmeticVO cosmeticVO)throws Exception;
	
	public void deleteCosmetic(Integer cosmetic_no)throws Exception;
	
	public List<CosmeticVO> listCosmetic(SearchCriteria cri)throws Exception;
	
	public int countCosmetic(SearchCriteria cri)throws Exception;
	*/
}

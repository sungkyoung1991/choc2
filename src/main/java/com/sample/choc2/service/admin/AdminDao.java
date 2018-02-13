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

	public BoardVO getBoard(Integer board_no) throws Exception;

	public void updateBoard(BoardVO boardVO) throws Exception;

	public void deleteBoard(Integer board_no) throws Exception;

	public List<BoardVO> listBoard(SearchCriteria cri) throws Exception;

	public int countBoard(SearchCriteria cri) throws Exception;

	public void updateViewCnt(Integer board_no) throws Exception;

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

	// =========================CosmeticDao=========================
	
	public void createCosmetic(CosmeticVO cosmeticVO)throws Exception;
	
	public CosmeticVO getCosmetic(Integer cosmetic_no)throws Exception;
	
	public void updateCosmetic(CosmeticVO cosmeticVO)throws Exception;
	
	public void deleteCosmetic(Integer cosmetic_no)throws Exception;
	
	public List<CosmeticVO> listCosmetic(SearchCriteria cri)throws Exception;
	
	public int countCosmetic(SearchCriteria cri)throws Exception;
}

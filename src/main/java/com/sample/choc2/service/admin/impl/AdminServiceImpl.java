package com.sample.choc2.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.admin.AdminDao;
import com.sample.choc2.service.admin.AdminService;
import com.sample.choc2.service.domain.BoardVO;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.ReplyVO;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	@Qualifier("adminDaoImpl")
	private AdminDao adminDao;
	
	public void setDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void createBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		adminDao.createBoard(boardVO);
	}

	@Override
	public BoardVO getBoard(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.getBoard(board_no);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateBoard(boardVO);
	}

	@Override
	public void deleteBoard(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		adminDao.deleteBoard(board_no);
	}

	@Override
	public List<BoardVO> listBoard(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.listBoard(cri);
	}

	@Override
	public int countBoard(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.countBoard(cri);
	}

	@Override
	public void createReply(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		adminDao.createReply(replyVO);
	}

	@Override
	public void updateReply(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateReply(replyVO);
	}

	@Override
	public void deleteReply(Integer reply_no) throws Exception {
		// TODO Auto-generated method stub
		adminDao.deleteReply(reply_no);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer board_no, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.listPageReply(board_no, cri);
	}

	@Override
	public int countReply(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.countReply(board_no);
	}

	@Override
	public void updateViewCnt(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateViewCnt(board_no);
	}

	@Override
	public int getBoardNo(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.getBoardNo(board_no);
	}

	@Override
	public void updateReplyCnt(Integer board_no, int amount) throws Exception {
		// TODO Auto-generated method stub
		//adminDao.updateReply();
	}

	@Override
	public void createCosmetic(CosmeticVO cosmeticVO) throws Exception {
		// TODO Auto-generated method stub
		adminDao.createCosmetic(cosmeticVO);
	}

	@Override
	public CosmeticVO getCosmetic(Integer cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.getCosmetic(cosmetic_no);
	}

	@Override
	public void updateCosmetic(CosmeticVO cosmeticVO) throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateCosmetic(cosmeticVO);
	}

	@Override
	public void deleteCosmetic(Integer cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		adminDao.deleteCosmetic(cosmetic_no);
	}

	@Override
	public List<CosmeticVO> listCosmetic(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.listCosmetic(cri);
	}

	@Override
	public int countCosmetic(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.countCosmetic(cri);
	}
	
	

}

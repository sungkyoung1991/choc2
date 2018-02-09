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
	public BoardVO getBoard(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.getBoard(bno);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateBoard(boardVO);
	}

	@Override
	public void deleteBoard(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		adminDao.deleteBoard(bno);
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
	public void deleteReply(Integer rno) throws Exception {
		// TODO Auto-generated method stub
		adminDao.deleteReply(rno);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.listPageReply(bno, cri);
	}

	@Override
	public int countReply(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.countReply(bno);
	}

	@Override
	public void updateViewCnt(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateViewCnt(bno);
	}

	@Override
	public int getBno(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.getBno(bno);
	}

	@Override
	public void updateReplyCnt(Integer bno, int amount) throws Exception {
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

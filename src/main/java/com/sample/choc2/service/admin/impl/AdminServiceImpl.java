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
	private AdminDao dao;
	
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

	@Override
	public BoardVO get(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.get(bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> list(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(cri);
	}

	@Override
	public int totalCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.totalCount(cri);
	}

	@Override
	public void createReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.createReply(vo);
	}

	@Override
	public void updateReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.updateReply(vo);
	}

	@Override
	public void deleteReply(Integer rno) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteReply(rno);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPageReply(bno, cri);
	}

	@Override
	public int countReply(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.countReply(bno);
	}

	@Override
	public void updateViewCnt(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		dao.updateViewCnt(bno);
	}

	@Override
	public int getBno(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.getBno(bno);
	}

	@Override
	public void updateReplyCnt(Integer bno, int amount) throws Exception {
		// TODO Auto-generated method stub
		//dao.updateReply();
	}

	@Override
	public void createCosmetic(CosmeticVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.createCosmetic(vo);
	}

	@Override
	public CosmeticVO getCosmetic(Integer cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		return dao.getCosmetic(cosmetic_no);
	}

	@Override
	public void updateCosmetic(CosmeticVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCosmetic(Integer cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteCosmetic(cosmetic_no);
	}

	@Override
	public List<CosmeticVO> listCosmetic(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCosmetic(cri);
	}

	@Override
	public int countCosmetic(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countCosmetic(cri);
	}
	
	

}

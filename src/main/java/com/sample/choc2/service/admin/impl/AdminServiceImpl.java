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
	
	

}

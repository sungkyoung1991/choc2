package com.sample.choc2.service.reply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.service.domain.ReplyVO;
import com.sample.choc2.service.reply.ReplyDao;
import com.sample.choc2.service.reply.ReplyService;

@Service("replyServiceImpl")
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	@Qualifier("replyDaoImpl")
	private ReplyDao replyDao;
	
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	
	public ReplyServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	@Override
	public void createReply(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		replyDao.createReply(replyVO);
	}

	@Override
	public void updateReply(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		replyDao.updateReply(replyVO);
	}

	@Override
	public void deleteReply(Integer replyNo) throws Exception {
		// TODO Auto-generated method stub
		replyDao.deleteReply(replyNo);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer boardNo, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.listPageReply(boardNo, cri);
	}

	@Override
	public int countReply(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.countReply(boardNo);
	}


	@Override
	public int getBoardNo(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.getBoardNo(boardNo);
	}

	@Override
	public void updateReplyCnt(Integer boardNo, int amount) throws Exception {
		// TODO Auto-generated method stub
		//adminDao.updateReply();
	}
}

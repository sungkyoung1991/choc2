package com.sample.choc2.service.reply.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.Search;
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
	public Map<String,Object> listReplyPage(Integer boardNo, Search search) throws Exception {
		// TODO Auto-generated method stub
		List<ReplyVO> list = replyDao.listPageReply(boardNo, search);
		int totalCount = replyDao.countReply(boardNo);
		System.out.println("replyDaoCount1 : "+totalCount);
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("totalCountReply", new Integer(totalCount));
		System.out.println("replyDaoCount2 : "+map.get("totalCountReply"));
		System.out.println("service map ..."+ map);
		return map;
	}

//	@Override
//	public int countReply(Integer boardNo) throws Exception {
//		// TODO Auto-generated method stub
//		return replyDao.countReply(boardNo);
//	}


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

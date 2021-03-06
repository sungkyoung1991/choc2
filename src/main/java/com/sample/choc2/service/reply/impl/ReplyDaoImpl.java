package com.sample.choc2.service.reply.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.ReplyVO;
import com.sample.choc2.service.reply.ReplyDao;

@Repository("replyDaoImpl")
public class ReplyDaoImpl implements ReplyDao {
	
	private static String NAMESPACE ="ReplyMapper";
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public ReplyDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Override
	public void createReply(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		session.insert(NAMESPACE + ".createReply", replyVO);

	}

	@Override
	public void updateReply(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		session.update(NAMESPACE + ".updateReply", replyVO);
	}

	@Override
	public void deleteReply(Integer replyNo) throws Exception {
		// TODO Auto-generated method stub
		session.delete(NAMESPACE + ".deleteReply", replyNo);
	}

	@Override
	public List<ReplyVO> listPageReply(Integer boardNo, Search search) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("boardNo", boardNo);
		paramMap.put("search", search);
		System.out.println("replydao"+paramMap);
		return session.selectList(NAMESPACE + ".listReplyPage", paramMap);
	}

	@Override
	public int countReply(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE + ".countReply", boardNo);
	}

	@Override
	public int getBoardNo(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE + ".getboardNo", boardNo);
	}

	@Override
	public void updateReplyCnt(Integer boardNo, int amount) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("boardNo", boardNo);
		paramMap.put("amount", amount);

		session.update(NAMESPACE + ".updateReplyCnt", paramMap);
	}
}

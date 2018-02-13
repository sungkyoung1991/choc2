package com.sample.choc2.service.reply.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.service.domain.ReplyVO;
import com.sample.choc2.service.reply.ReplyDao;

@Repository("replyDaoImpl")
public class ReplyDaoImpl implements ReplyDao {
	
	private static String namespace ="ReplyMapper";
	
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
		session.insert(namespace + ".createReply", replyVO);

	}

	@Override
	public void updateReply(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".updateReply", replyVO);
	}

	@Override
	public void deleteReply(Integer reply_no) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteReply", reply_no);
	}

	@Override
	public List<ReplyVO> listPageReply(Integer board_no, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("board_no", board_no);
		paramMap.put("cri", cri);

		return session.selectList(namespace + ".listReplyPage", paramMap);
	}

	@Override
	public int countReply(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".countReply", board_no);
	}

	@Override
	public int getBoardNo(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".getBoard_No", board_no);
	}

	@Override
	public void updateReplyCnt(Integer board_no, int amount) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("board_no", board_no);
		paramMap.put("amount", amount);

		session.update(namespace + ".updateReplyCnt", paramMap);
	}
}

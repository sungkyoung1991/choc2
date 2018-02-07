package com.sample.choc2.service.admin.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.admin.AdminDao;
import com.sample.choc2.service.domain.BoardVO;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.ReplyVO;

@Repository("adminDaoImpl")
public class AdminDaoImpl implements AdminDao {

	private static String namespace = "AdminMapper";

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
	}

	@Override
	public BoardVO get(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".get", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", bno);
	}

	@Override
	public List<BoardVO> list(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list", cri);
	}

	@Override
	public int totalCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".totalCount", cri);
	}

	@Override
	public void createReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".createReply", vo);

	}

	@Override
	public void updateReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".updateReply", vo);
	}

	@Override
	public void deleteReply(Integer rno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteReply", rno);
	}

	@Override
	public List<ReplyVO> listPageReply(Integer bno, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("bno", bno);
		paramMap.put("cri", cri);

		return session.selectList(namespace + ".listReplyPage", paramMap);
	}

	@Override
	public int countReply(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".countReply", bno);
	}

	@Override
	public int getBno(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".getBno", bno);
	}

	@Override
	public void updateViewCnt(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".updateViewCnt", bno);
	}

	@Override
	public void updateReplyCnt(Integer bno, int amount) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("bno", bno);
		paramMap.put("amount", amount);

		session.update(namespace + ".updateReplyCnt", paramMap);
	}

	@Override
	public void createCosmetic(CosmeticVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".createCosmetic",vo);
	}

	@Override
	public CosmeticVO getCosmetic(Integer cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getCosmetic",cosmetic_no);
	}

	@Override
	public void updateCosmetic(CosmeticVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".updateCosmetic",vo);
	}

	@Override
	public void deleteCosmetic(Integer cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteCosmetic",cosmetic_no);
	}

	@Override
	public List<CosmeticVO> listCosmetic(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listCosmetic", cri);
	}

	@Override
	public int countCosmetic(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".countCosmetic",cri);
	}

}

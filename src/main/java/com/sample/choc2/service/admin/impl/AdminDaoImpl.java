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

	private static String NAMESPACE = "AdminMapper";

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public void createBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		session.insert(NAMESPACE + ".createBoard", boardVO);
	}

	@Override
	public BoardVO getBoard(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE + ".getBoard", boardNo);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		session.update(NAMESPACE + ".updateBoard", boardVO);
	}

	@Override
	public void deleteBoard(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		session.delete(NAMESPACE + ".deleteBoard", boardNo);
	}

	@Override
	public List<BoardVO> listBoard(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE + ".listBoard", cri);
	}

	@Override
	public int countBoard(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE + ".countBoard", cri);
	}

	
	@Override
	public void updateViewCnt(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		session.update(NAMESPACE + ".updateViewCnt", boardNo);
	}

}

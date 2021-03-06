package com.sample.choc2.service.board.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.Search;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.board.BoardDao;
import com.sample.choc2.service.domain.BoardVO;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.ReplyVO;

@Repository("boardDaoImpl")
public class BoardDaoImpl implements BoardDao {

	private static String NAMESPACE = "BoardMapper";

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
	public List<BoardVO> getBoardList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE + ".getBoardList", search);
	}

	@Override
	public int totalCountBoard(Search search) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("searchDao..."+search);
		return session.selectOne(NAMESPACE + ".totalCountBoard", search);
	}

	
	@Override
	public void updateViewCnt(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		session.update(NAMESPACE + ".updateViewCnt", boardNo);
	}

}

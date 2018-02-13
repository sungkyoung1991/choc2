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
	public void createBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".createBoard", boardVO);
	}

	@Override
	public BoardVO getBoard(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".getBoard", board_no);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".updateBoard", boardVO);
	}

	@Override
	public void deleteBoard(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteBoard", board_no);
	}

	@Override
	public List<BoardVO> listBoard(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listBoard", cri);
	}

	@Override
	public int countBoard(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".countBoard", cri);
	}

	
	@Override
	public void updateViewCnt(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".updateViewCnt", board_no);
	}
	/*
	@Override
	public void createCosmetic(CosmeticVO cosmeticVO) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".createCosmetic",cosmeticVO);
	}

	@Override
	public CosmeticVO getCosmetic(Integer cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getCosmetic",cosmetic_no);
	}

	@Override
	public void updateCosmetic(CosmeticVO cosmeticVO) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".updateCosmetic",cosmeticVO);
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
*/
}

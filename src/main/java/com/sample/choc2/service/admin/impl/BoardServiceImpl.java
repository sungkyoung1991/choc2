package com.sample.choc2.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.admin.BoardDao;
import com.sample.choc2.service.admin.BoardSerivce;
import com.sample.choc2.service.domain.BoardVO;

@Service("boardServiceImpl")
public class BoardServiceImpl implements BoardSerivce{
	
	@Autowired
	@Qualifier("boardDaoImpl")
	private BoardDao dao;
	
	public void setDao(BoardDao dao) {
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
	
	

}

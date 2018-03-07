package com.sample.choc2.service.admin.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.Search;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.admin.AdminDao;
import com.sample.choc2.service.admin.AdminService;
import com.sample.choc2.service.domain.BoardVO;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.ReplyVO;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	@Qualifier("adminDaoImpl")
	private AdminDao adminDao;
	
	public void setDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	@Override
	public void createBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		adminDao.createBoard(boardVO);
	}

	@Override
	public BoardVO getBoard(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.getBoard(boardNo);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateBoard(boardVO);
	}

	@Override
	public void deleteBoard(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		adminDao.deleteBoard(boardNo);
	}

	@Override
	public Map<String,Object> getBoardList(Search search) throws Exception {
		// TODO Auto-generated method stub
		List<BoardVO> list = adminDao.getBoardList(search);
		int totalCountBoard= adminDao.totalCountBoard(search);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("totalCountBoard", new Integer(totalCountBoard));
				System.out.println("service map ..... "+map);
		
		return map;
	}

	@Override
	public void updateViewCnt(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateViewCnt(boardNo);
		
	}

}

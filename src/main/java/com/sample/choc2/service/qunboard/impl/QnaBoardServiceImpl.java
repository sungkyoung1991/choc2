package com.sample.choc2.service.qunboard.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.QnaBoardVO;
import com.sample.choc2.service.qunboard.QnaBoardDao;
import com.sample.choc2.service.qunboard.QnaBoardServie;

@Service("qnaBoardServiceImpl")
public class QnaBoardServiceImpl implements QnaBoardServie{

	@Autowired
	@Qualifier("qnaBoardDaoImpl")
	private QnaBoardDao qnaBoardDao;
	
	public void setQnaBoardDao(QnaBoardDao qnaBoardDao) {
		this.qnaBoardDao = qnaBoardDao;
	}
	public QnaBoardServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Override
	public void createQnaBoard(QnaBoardVO qnaBoardVO) throws Exception {
		// TODO Auto-generated method stub
		qnaBoardDao.createQnaBoard(qnaBoardVO);
	}
	@Override
	public Map<String, Object> getQnaBoardList(Search search) throws Exception {
		// TODO Auto-generated method stub
		List<QnaBoardVO> list = qnaBoardDao.getQnaBoardList(search);
		int totalCountQnaBoard = qnaBoardDao.totalCountQnaBoard(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("list",list);
		map.put("totalCountQnaBoard",new Integer(totalCountQnaBoard));
		
		//System.out.println("list :"+map.get("list"));
		//System.out.println("totalCountQnaBoard :"+map.get("totalCountQnaBoard"));
		
		return map;
	}

}

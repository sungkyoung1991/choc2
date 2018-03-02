package com.sample.choc2.common.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.common.domain.CrawlingVO;
import com.sample.choc2.common.service.CrawlingDao;
import com.sample.choc2.web.supermanage.SuperManageController;

@Repository("crawlingDaoImpl")
public class CrawlingDaoImpl implements CrawlingDao{
	private static Logger logger = LoggerFactory.getLogger(SuperManageController.class);
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	private static String NAMESPACE = "CrawlingMapper";
	
	public CrawlingDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void createOvlieCrawling(CrawlingVO crawlingVO) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Crawling DAO :"+crawlingVO.toString());
		sqlSession.insert(NAMESPACE+".createCrawlingOlive",crawlingVO);
		
	}

}
